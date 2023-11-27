package functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction{
    protected static class Node{
        public Node next;
        public Node prev;
        public double x;
        public double y;
    }

    private Node head;

    private void addNode(double x, double y){
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        if (head == null){
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        }
        else{
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
        }
    }
    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < xValues.length; i++) {
            addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            xFrom=xFrom+xTo;
            xTo=xFrom-xTo;
            xFrom=xFrom-xTo;
        }
        double step = (xTo - xFrom) / (count - 1);
        double x = xFrom;
        for (int i = 0; i < count; i++) {
            addNode(x, source.apply(x));
            x += step;
        }
    }
    @Override
    public int getCount() {
        return count;
    }
    @Override
    public double leftBound() {
        return head.x;
    }
    @Override
    public double rightBound() {
        return head.prev.x;
    }
    private Node getNode(int index) {
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    @Override
    public double getX(int index) {
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        getNode(index).y = value;
    }

    @Override
    public int indexOfX(double x) {
        Node node = head;
        for (int i = 0; i < count; i++) {
            if (node.x == x) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node node = head;
        for (int i = 0; i < count; i++) {
            if (node.y == y) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    @Override
    public int floorIndexOfX(double x) {
        if (x < head.x) {
            return -1;
        }
        if (x > head.prev.x) {
            return count - 2;
        }
        int index = 0;
        Node node = head;
        while (x >= node.next.x) {
            index++;
            node = node.next;
        }
        return index;
    }

    @Override
    public double interpolate(double x, int floorIndex) {
        Node leftNode = getNode(floorIndex);
        Node rightNode = leftNode.next;
        return leftNode.y+((rightNode.y - leftNode.y)*(x-leftNode.x)) / (rightNode.x - leftNode.x);

    }

    @Override
    public double extrapolateLeft(double x) {
        Node leftNode = head;
        Node rightNode = leftNode.next;
        if (x > rightNode.x) {
            double k = (rightNode.y - leftNode.y) / (rightNode.x - leftNode.x);
            double b = leftNode.y - k * leftNode.x;
            return k * x + b;
        } else {
            return interpolate(x, 0);
        }
    }

    @Override
    public double extrapolateRight(double x) {
        Node rightNode = head.prev;
        Node leftNode = rightNode.prev;
        if (x < leftNode.x) {
            double k = (rightNode.y - leftNode.y) / (rightNode.x - leftNode.x);
            double b = leftNode.y - k * leftNode.x;
            return k * x + b;
        } else {
            return interpolate(x, count - 2);
        }
    }
}
