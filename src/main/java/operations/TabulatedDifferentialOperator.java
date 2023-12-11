package operations;

import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {

    private TabulatedFunctionFactory factory;
    private TabulatedFunctionOperationService operationService;

    public TabulatedDifferentialOperator() {
        factory = new ArrayTabulatedFunctionFactory();
        operationService = new TabulatedFunctionOperationService();
    }

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
        operationService = new TabulatedFunctionOperationService();
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] points = operationService.asPoints(function);
        double[] xValues = new double[points.length];
        double[] yValues = new double[points.length];

        for (int i = 0; i < points.length; i++) {
            xValues[i] = points[i].x;
            yValues[i] = derivative(xValues[i], function);
        }

        return factory.create(xValues, yValues);
    }

    private double derivative(double x, TabulatedFunction function) {
        double h = 1e-5;
        return (function.getY((int) (x + h)) - function.getY((int) (x - h))) / (2 * h);
    }
}