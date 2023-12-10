package exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException(){}
    public ArrayIsNotSortedException(String description){
        super(description);
    }
}
