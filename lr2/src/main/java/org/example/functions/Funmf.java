package org.example.functions;

public class Funmf implements MathFunction {
    public double a;

    public double apply(double x){
        return Math.pow(a,Math.log(x) / Math.log(a));
    }
}