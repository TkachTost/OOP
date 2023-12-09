package functions;

public class IdentityFunction implements MathFunction, Cloneable{
    public double apply(double x){
        return x;
    }

    @Override
    public String toString() {
        return "class: IdentityFunction";
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof IdentityFunction){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return 0x1503;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
