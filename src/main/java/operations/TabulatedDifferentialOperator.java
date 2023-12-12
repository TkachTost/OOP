package operations;

import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {

    private TabulatedFunctionFactory factory;
    public TabulatedDifferentialOperator() {
        factory = new ArrayTabulatedFunctionFactory();
    }
    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    public TabulatedFunctionFactory getFactory() {
        return factory;
    }
    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        TabulatedFunctionOperationService operationService=new TabulatedFunctionOperationService();
        Point[] points = operationService.asPoints(function);
        double[] xValues = new double[points.length];
        double[] yValues = new double[points.length];
        for (int i = 0; i < points.length-1; i++) {
            xValues[i] = points[i].x;
            yValues[i] = (points[i+1].y-points[i].y)/(points[i+1].x-xValues[i]);
        }
        xValues[points.length-1]= points[points.length-1].x;
        yValues[points.length-1]= yValues[points.length-2];
        return factory.create(xValues, yValues);
    }
}