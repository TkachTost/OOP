package functions.factory;

import functions.AbstractTabulatedFunction;
import functions.ArrayTabulatedFunction;
import functions.MathFunction;
import functions.TabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues){
        AbstractTabulatedFunction cr=new ArrayTabulatedFunction(xValues,yValues);
        return cr;
    }

    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new ArrayTabulatedFunction(source, xFrom, xTo, count);
    }
}
