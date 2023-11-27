package functions;

public interface MathFunction {
    public double apply(double x);

      public default CompositeFunction andThen(MathFunction afterFunction) {
          return new CompositeFunction(afterFunction, this);
      }
}