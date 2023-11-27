package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.soap.Node;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {
    private double[] xval={1,2,3,4,5};
    private double[] yval={1,2,3,4,5};
    LinkedListTabulatedFunction list=new LinkedListTabulatedFunction(xval,yval);
    @Test
    public void testLeftBound() {
        Assert.assertEquals(xval[0],list.leftBound());
    }

    @Test
    public void testRightBound() {
        Assert.assertEquals(xval[4],list.rightBound());
    }


    @Test
    public void testGetX() {
        for (int i=0;i<5;i++){
            Assert.assertEquals(xval[i],list.getX(i));
        }
    }

    @Test
    public void testGetY() {
        for (int i=0;i<5;i++){
            Assert.assertEquals(yval[i],list.getY(i));
        }
    }

    @Test
    public void testSetY() {
        for (int i=0;i<5;i++){
            yval[i]=i+5;
            list.setY(i,i+5);
        }
        for (int i=0;i<5;i++){
            Assert.assertEquals(yval[i],list.getY(i));
        }
    }
    @Test
    public void testInterpolate() {
        Assert.assertEquals(1.0,list.interpolate(1,2));
        Assert.assertEquals(2.0,list.interpolate(2,2));
    }

    @Test
    public void testExtrapolateLeft() {
        Assert.assertEquals(1.0,list.extrapolateLeft(1));
        Assert.assertEquals(2.0,list.extrapolateLeft(2));
    }

    @Test
    public void testExtrapolateRight() {
        Assert.assertEquals(1.0,list.extrapolateLeft(1));
        Assert.assertEquals(2.0,list.extrapolateLeft(2));
    }
}