package functions;

import exceptions.InterpolationException;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Cloneable{
    private double[] xValues;
    private double[] yValues;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        ArrayTabulatedFunction.checkLengthIsTheSame(xValues, yValues);
        ArrayTabulatedFunction.checkSorted(xValues);
        ArrayTabulatedFunction.checkSorted(yValues);
        this.count = xValues.length;
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            xFrom=xFrom+xTo;
            xTo=xFrom-xTo;
            xFrom=xFrom-xTo;
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

    public int getCount(){
        return count;
    }

    @Override
    public double getX(int index) {
        return this.xValues[index];
    }
    @Override
    public double getY(int index) {
        return this.yValues[index];
    }
    public void setY(int index, double value){
        this.yValues[index]=value;
    }
    @Override
    public double leftBound() {
        return xValues[0];
    }
    public double rightBound(){
        return xValues[xValues.length - 1];
    }
    @Override
    public int indexOfX(double x){
        for (int i = 0; i < getCount(); i++){
            if (xValues[i] == x)
                return i;
        }
        return -1;
    }
    @Override
    public int indexOfY(double y){
        for (int i = 0; i < getCount(); i++){
            if (yValues[i] == y)
                return i;
        }
        return -1;
    }
    @Override
    protected int floorIndexOfX(double x) {
        if (x < xValues[0]) {
            return 0;
        }
        if (x >= xValues[count - 1]) {
            return count;
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
        if(x<xValues[floorIndex]||x>xValues[floorIndex+1]){
            throw new InterpolationException();
        }
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
    public String toString(){
        String result=new String();
        for (int i=0;i<count;i++) {
            result = result + xValues[i] + " ";
        }
        for (int i=0;i<count;i++) {
            result = result + yValues[i] + " ";
        }
        return result;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof ArrayTabulatedFunction){
            ArrayTabulatedFunction arr=(ArrayTabulatedFunction) o;
            for(int i=0;i<count;i++){
                if(((ArrayTabulatedFunction) o).xValues[i]!=this.xValues[i]||((ArrayTabulatedFunction) o).yValues[i]!=this.yValues[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < count; i++) {
            hash += Double.hashCode(xValues[i]) ^ Double.hashCode(yValues[i]);
        }
        return hash;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (ArrayTabulatedFunction)super.clone();
    }
    @Override
    public Iterator<Point> iterator()  {
        throw new UnsupportedOperationException();
    }
}