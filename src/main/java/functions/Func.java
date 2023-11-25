package functions;

public class Func implements MathFunction {
    public double a;
    public double apply(double x){
        return Math.pow(a,Math.log(x)/Math.log(a));
    }
}
