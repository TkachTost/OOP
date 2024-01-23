package operations;

import exceptions.InconsistentFunctionsException;
import functions.*;
import functions.factory.*;

import java.util.Iterator;

public class TabulatedFunctionOperationService {
    private TabulatedFunctionFactory factory;
    public TabulatedFunctionOperationService(){
        ArrayTabulatedFunctionFactory factory=new ArrayTabulatedFunctionFactory();
        this.factory=factory;
    };
    public TabulatedFunctionOperationService(TabulatedFunctionFactory factory){
        this.factory=factory;
    }
    public TabulatedFunctionFactory getFactory() {
        return factory;
    }
    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    public static Point[] asPoints(TabulatedFunction tabulatedFunction){
        Point[] points = new Point[tabulatedFunction.getCount()];
        int i = 0;
        for (Point point : tabulatedFunction) {
            points[i] = point;
            i++;
        }
        return points;
    }
    private interface BiOperation{
        double apply(double u, double v);
    }
    private TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, BiOperation operation) throws InconsistentFunctionsException {
        int sizeA = a.getCount();
        int sizeB = b.getCount();
        if (sizeA != sizeB) {
            throw new InconsistentFunctionsException("Number of points in the functions is not equal");
        }
        Point[] pointsA = asPoints(a);
        Point[] pointsB = asPoints(b);
        double[] xValues = new double[sizeA];
        double[] yValues = new double[sizeA];
        for (int i = 0; i < sizeA; i++) {
            xValues[i] = pointsA[i].x;
            if (xValues[i] != pointsB[i].x) {
                throw new InconsistentFunctionsException("X values in the functions are not equal");
            }
            yValues[i] = operation.apply(pointsA[i].y, pointsB[i].y);
        }
        return factory.create(xValues, yValues);
    }
    public TabulatedFunction add(TabulatedFunction a, TabulatedFunction b) throws InconsistentFunctionsException {
        return doOperation(a, b, (u, v) -> u + v);
    }

    public TabulatedFunction subtract(TabulatedFunction a, TabulatedFunction b) throws InconsistentFunctionsException {
        return doOperation(a, b, (u, v) -> u - v);
    }
    public TabulatedFunction multiply(TabulatedFunction a, TabulatedFunction b) throws InconsistentFunctionsException {
        return doOperation(a, b, (u, v) -> u * v);
    }
    public TabulatedFunction divide(TabulatedFunction a, TabulatedFunction b) throws InconsistentFunctionsException {
        return doOperation(a, b, (u, v) -> u / v);
    }
    public TabulatedFunction Addition(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u + v;
        return doOperation(firstFunction, secondFunction, operation);
    }
    public TabulatedFunction Subtraction(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u - v;
        return doOperation(firstFunction, secondFunction, operation);
    }
}
