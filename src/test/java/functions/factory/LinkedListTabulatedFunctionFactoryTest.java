package functions.factory;

import functions.AbstractTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionFactoryTest {

    @Test
    public void testCreate() {
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        LinkedListTabulatedFunctionFactory arr=new LinkedListTabulatedFunctionFactory();
        Assert.assertTrue(arr.create(x,y) instanceof LinkedListTabulatedFunction);
    }
}