package exceptions;

public class InterpolationException extends RuntimeException{
    public InterpolationException(){}
    public InterpolationException(String description){
        super(description);
    }
}
