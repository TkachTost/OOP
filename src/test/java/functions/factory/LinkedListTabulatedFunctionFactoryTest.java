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
        LinkedListTabulatedFunction arrar= (LinkedListTabulatedFunction) arr.create(x,y);
        for (int i=0;i<5;i++){
            Assert.assertEquals(x[i],arrar.getX(i));
            Assert.assertEquals(y[i],arrar.getY(i));
        }
    }
}