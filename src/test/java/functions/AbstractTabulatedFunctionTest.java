package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {

    @Test(expectedExceptions = DifferentLengthOfArraysException.class)
    public void testCheckLengthIsTheSame() {
        double[] arr1=new double[]{1,2,3};
        double[] arr2=new double[]{1,2,3,4,5};
        AbstractTabulatedFunction.checkLengthIsTheSame(arr1,arr2);
    }

    @Test(expectedExceptions = ArrayIsNotSortedException.class)
    public void testCheckSorted() {
        double[] arr1=new double[]{1,2,3,5,4};
        double[] arr2=new double[]{5,4,3,2,1};
        AbstractTabulatedFunction.checkSorted(arr1);
        AbstractTabulatedFunction.checkSorted(arr2);
    }
}