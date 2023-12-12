package operations;

import functions.AbstractTabulatedFunction;
import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.factory.LinkedListTabulatedFunctionFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TabulatedDifferentialOperatorTest {

    @Test
    public void testDerive() {
        TabulatedDifferentialOperator testic=new TabulatedDifferentialOperator();
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,4,7,11};
        double[] res=new double[]{1,2,3,4,4};
        ArrayTabulatedFunction arr=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr1= (ArrayTabulatedFunction) testic.derive(arr);
        AbstractTabulatedFunction arr2=new ArrayTabulatedFunction(x,res);
        for(int i=0;i<5;i++){
            Assert.assertEquals(arr1.getX(i),arr2.getX(i));
            Assert.assertEquals(arr1.getY(i),arr2.getY(i));
        }
    }
}