package functions;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    protected int count;

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (x - leftX) * (rightY - leftY) / (rightX - leftX);
    }

    @Override
    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else {
            int index = indexOfX(x);
            if (index != -1) {
                return getY(index);
            } else {
                int floorIndex = floorIndexOfX(x);
                return interpolate(x, floorIndex);
            }
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (getX(i) == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (getY(i) == y) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void setY(int index, double value) {
        if (index >= 0 && index < count) {
            double oldY = getY(index);
            if (oldY != value) {
                setYImpl(index, value);
            }
        } else {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    protected abstract void setYImpl(int index, double value);

    @Override
    public double leftBound() {
        return getX(0);
    }

    @Override
    public double rightBound() {
        return getX(count - 1);
    }
}
