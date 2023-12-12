package operations;

import functions.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {

    @Test
    public void testAsPoints() {
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        ArrayTabulatedFunction arr=new ArrayTabulatedFunction(x,y);
        Point[] points=TabulatedFunctionOperationService.asPoints(arr);
        for (int i=0;i<5;i++){
            Assert.assertEquals(points[i].x,arr.getX(i));
            Assert.assertEquals(points[i].y,arr.getY(i));
        }
    }

    @Test
    public void testAdd() {
        TabulatedFunctionOperationService tab=new TabulatedFunctionOperationService();
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        ArrayTabulatedFunction arr=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr1=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr3;
        arr3= (ArrayTabulatedFunction) tab.add(arr,arr1);
        for (int i=0;i<5;i++){
            Assert.assertEquals(arr3.getX(i),(double) (i+1));
            Assert.assertEquals(arr3.getY(i),(double) (i+1)*2);
        }
    }

    @Test
    public void testSubtract() {
        TabulatedFunctionOperationService tab=new TabulatedFunctionOperationService();
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        ArrayTabulatedFunction arr=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr1=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr3;
        arr3= (ArrayTabulatedFunction) tab.subtract(arr,arr1);
        for (int i=0;i<5;i++){
            Assert.assertEquals(arr3.getX(i),(double) (i+1));
            Assert.assertEquals(arr3.getY(i),(double) (i+1)-(i+1));
        }
    }

    @Test
    public void testMultiply() {
        TabulatedFunctionOperationService tab=new TabulatedFunctionOperationService();
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        ArrayTabulatedFunction arr=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr1=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr3;
        arr3= (ArrayTabulatedFunction) tab.multiply(arr,arr1);
        for (int i=0;i<5;i++){
            Assert.assertEquals(arr3.getX(i),(double) (i+1));
            Assert.assertEquals(arr3.getY(i),(double) (i+1)*(i+1));
        }
    }

    @Test
    public void testDivide() {
        TabulatedFunctionOperationService tab=new TabulatedFunctionOperationService();
        double[] x=new double[]{1,2,3,4,5};
        double[] y=new double[]{1,2,3,4,5};
        ArrayTabulatedFunction arr=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr1=new ArrayTabulatedFunction(x,y);
        ArrayTabulatedFunction arr3;
        arr3= (ArrayTabulatedFunction) tab.divide(arr,arr1);
        for (int i=0;i<5;i++){
            Assert.assertEquals(arr3.getX(i),(double) (i+1));
            Assert.assertEquals(arr3.getY(i),(double) (i+1)/(i+1));
        }
    }
}