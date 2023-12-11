package functions.factory;

import functions.AbstractTabulatedFunction;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionFactoryTest {

    @Test
    public void testCreate() {
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        ArrayTabulatedFunctionFactory arr=new ArrayTabulatedFunctionFactory();
        Assert.assertTrue(arr.create(x,y) instanceof AbstractTabulatedFunction);
    }
}