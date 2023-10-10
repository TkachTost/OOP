package org.example.functions;

public class LinkedListTabulatedFunction implements TabulatedFunction {
    private int count;
    private Node head;

    private static class Node {
        private double x;
        private double y;
        private Node prev;
        private Node next;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
            this.prev = this;
            this.next = this;
        }
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new IllegalArgumentException("Lengths of x and y arrays are different");
        }
        for (int i = 0; i < xValues.length; i++) {
            addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        if (count < 2) {
            addNode(xFrom, source.apply(xFrom));
        } else {
            double step = (xTo - xFrom) / (count - 1);
            for (int i = 0; i < count - 1; i++) {
                addNode(xFrom + i * step, source.apply(xFrom + i * step));
            }
            addNode(xTo, source.apply(xTo));
        }
    }

    private void addNode(double x, double y) {
        Node newNode = new Node(x, y);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
        count++;
    }

    @Override
    public int getCount() {
        return count;
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
    public double leftBound() {
        return head.x;
    }

    @Override
    public double rightBound() {
        return head.prev.x;
    }

    @Override
    public int indexOfX(double x) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.x == x) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.y == y) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }


    public int floorIndexOfX(double x) {
        if (x < head.x) {
            return -1;
        }
        if (x >= head.prev.x) {
            return count - 2;
        }
        Node current = head;
        for (int i = 0; i < count - 1; i++) {
            if (current.x > x) {
                return i - 1;
            }
            current = current.next;
        }
        return -1; // This line is never reached, but required by Java syntax
    }


    public double interpolate(double x, int floorIndex) {
        if (floorIndex < 0 || floorIndex >= count - 1) {
            throw new IllegalArgumentException("Invalid floor index");
        }
        Node left = getNode(floorIndex);
        Node right = left.next;
        double k = (y(right) - y(left)) / (x(right) - x(left));
        double b = y(left) - k * x(left);
        return k * x + b;
    }


    public double extrapolateLeft(double x) {
        if (count == 1) {
            return head.y;
        }
        Node left = head;
        Node right = head.next;
        double k = (y(right) - y(left)) / (x(right) - x(left));
        double b = y(left) - k * x(left);
        return k * x + b;
    }


    public double extrapolateRight(double x) {
        if (count == 1) {
            return head.y;

        }
        Node left = head.prev.prev;
        Node right = head.prev;
        double k = (y(right) - y(left)) / (x(right) - x(left));
        double b = y(left) - k * x(left);
        return k * x + b;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private double x(Node node) {
        return node.x;
    }

    private double y(Node node) {
        return node.y;
    }

    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        }
        if (x > rightBound()) {
            return extrapolateRight(x);
        }
        int index = indexOfX(x);
        if (index != -1) {
            return getY(index);
        }
        int floorIndex = floorIndexOfX(x);
        return interpolate(x, floorIndex);
    }
}
