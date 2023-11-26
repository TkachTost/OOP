package functions;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction{
    private double[] xValues;
    private double[] yValues;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new IllegalArgumentException("Lengths of arrays are not equal");
        }
        this.count = xValues.length;
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        this.count = count;
        this.xValues = new double[count];
        this.yValues = new double[count];
        if (count == 1) {
            double x = (xFrom + xTo) / 2;
            double y = source.apply(x);
            Arrays.fill(xValues, x);
            Arrays.fill(yValues, y);
        } else {
            double step = (xTo - xFrom) / (count - 1);
            for (int i = 0; i < count; i++) {
                xValues[i] = xFrom + i * step;
                yValues[i] = source.apply(xValues[i]);
            }
        }
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x < xValues[0]) {
            return 0;
        }
        if (x >= xValues[count - 1]) {
            return count - 2;
        }
        for (int i = 0; i < count - 1; i++) {
            if (x >= xValues[i] && x < xValues[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        if (count == 1) {
            return yValues[0];
        }
        double leftX = xValues[0];
        double rightX = xValues[1];
        double leftY = yValues[0];
        double rightY = yValues[1];
        return interpolate(x, leftX, rightX, leftY, rightY);
    }

    @Override
    protected double extrapolateRight(double x) {
        if (count == 1) {
            return yValues[0];
        }
        double leftX = xValues[count - 2];
        double rightX = xValues[count - 1];
        double leftY = yValues[count - 2];
        double rightY = yValues[count - 1];
        return interpolate(x, leftX, rightX, leftY, rightY);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (count == 1) {
            return yValues[0];
        }
        double leftX = xValues[floorIndex];
        double rightX = xValues[floorIndex + 1];
        double leftY = yValues[floorIndex];
        double rightY = yValues[floorIndex + 1];
        return interpolate(x, leftX, rightX, leftY, rightY);
    }

    @Override
    protected void setYImpl(int index, double value) {
        yValues[index] = value;
    }

    @Override
    public double getX(int index) {
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        return yValues[index];
    }
}
