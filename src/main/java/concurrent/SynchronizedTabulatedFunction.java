package concurrent;

import functions.*;
import functions.TabulatedFunction;
import operations.TabulatedFunctionOperationService;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    private final TabulatedFunction delegator;

    public SynchronizedTabulatedFunction(TabulatedFunction delegator) {
        this.delegator = delegator;
    }

    public int getCount() {
        synchronized (delegator) {
            return delegator.getCount();
        }
    }

    public double getX(int index) {
        synchronized (delegator) {
            return delegator.getX(index);
        }
    }

    public double getY(int index) {
        synchronized (delegator) {
            return delegator.getY(index);
        }
    }

    public void setY(int index, double value) {
        synchronized (delegator) {
            delegator.setY(index, value);
        }
    }

    public int indexOfX(double value) {
        synchronized (delegator) {
            return delegator.indexOfX(value);
        }
    }

    public int indexOfY(double value) {
        synchronized (delegator) {
            return delegator.indexOfY(value);
        }
    }

    public double rightBound() {
        synchronized (delegator) {
            return delegator.rightBound();
        }
    }

    public double leftBound() {
        synchronized (delegator) {
            return delegator.leftBound();
        }
    }

    public Iterator<Point> iterator() {
        synchronized (delegator) {
            Point[] copies = TabulatedFunctionOperationService.asPoints(delegator);
            return new Iterator<Point>() {
                int i = 0;

                @Override
                public boolean hasNext() {
                    return (i < copies.length);
                }

                @Override
                public Point next() {
                    Point point;
                    if (hasNext()) point = copies[i++];
                    else throw new NoSuchElementException();
                    return point;
                }
            };
        }
    }

    @Override
    public double apply(double x) {
        synchronized (delegator) {
            return delegator.apply(x);
        }
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction func);
    }

    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (delegator) {
            return operation.apply(this);
        }
    }
}
