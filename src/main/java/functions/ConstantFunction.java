package functions;

public class ConstantFunction implements MathFunction{
    private final double cnst;
    public ConstantFunction(double cnst){
        this.cnst=cnst;
    }
    public double getCnst(){
        return cnst;
    }
    public double apply(double x){
        return cnst;
    }
}
