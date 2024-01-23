package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;

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
    public static void checkLengthIsTheSame(double[] xValues, double[] yValues){
        if(xValues.length!=yValues.length){
            throw new DifferentLengthOfArraysException("Разные размеры");
        }
    }
    public static void checkSorted(double[] xValues){
        for (int i=0;i< xValues.length-1;i++){
            if (xValues[i]>xValues[i+1]){
                throw new ArrayIsNotSortedException("Не отсортировано");
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" size = ");
        sb.append(getCount());
        sb.append("\n");
        for (Point point : this) {
            sb.append("[");
            sb.append(point.x);
            sb.append("; ");
            sb.append(point.y);
            sb.append("]\n");
        }
        return sb.toString();
    }
}
