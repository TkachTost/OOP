package functions;

public class IdentityFunction implements MathFunction{
    public double apply(double x){
        return x;
    }

    @Override
    public String toString() {
        return "class: IdentityFunction";
    }
    public boolean equals(Object o){
        if(o instanceof IdentityFunction){
            return true;
        }
        return false;
    }
    public int hashCode(){
        return 0x1503;
    }
    public Object clone(){
        Object o=new Object();
        o=this;
        return o;
    }
}
