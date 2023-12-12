package functions.factory;

import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory{
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        LinkedListTabulatedFunction cr=new LinkedListTabulatedFunction(xValues,yValues);
        return cr;
    }
}
