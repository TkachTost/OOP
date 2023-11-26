package functions;

public interface MathFunction {
    public double apply(double x);

      public default CompositeFunction andThen(MathFunction afterFunction) {
          return new CompositeFunction(afterFunction, this);
      }
//    default MathFunction andThen(MathFunction afterFunction) {
//        return (double x) -> afterFunction.apply(this.apply(x));
//    }
//    public default MathFunction andThen(MathFunction afterFunction) {
//        return x -> afterFunction.apply(apply(x));
//    }
}