package functions.factory;

import functions.AbstractTabulatedFunction;
import functions.ArrayTabulatedFunction;
import functions.TabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues){
        AbstractTabulatedFunction cr=new ArrayTabulatedFunction(xValues,yValues);
        return cr;
    }
}