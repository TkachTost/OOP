package exceptions;

public class DifferentLengthOfArraysException extends RuntimeException{
    public DifferentLengthOfArraysException(){}
    public DifferentLengthOfArraysException(String description){
        super(description);
    }
}
