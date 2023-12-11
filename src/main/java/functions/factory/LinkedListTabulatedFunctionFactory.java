package functions.factory;

import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory{
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        LinkedListTabulatedFunction cr=new LinkedListTabulatedFunction(xValues,yValues);
        return cr;
    }
}