package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayTabulatedFunctionTest {

    private double[] xval={1,2,3,4,5};
    private double[] yval={1,2,3,4,5};
    private ArrayTabulatedFunction val=new ArrayTabulatedFunction(xval,yval);
    @Test
    public void testGetCount() {
        Assert.assertEquals(val.count,val.getCount());
    }

    @Test
    public void testGetX() {
        for (int i=0;i<val.getCount();i++){
            Assert.assertEquals(xval[i],val.getX(i));
        }
    }

    @Test
    public void testGetY() {
        for (int i=0;i<val.getCount();i++){
            Assert.assertEquals(yval[i],val.getY(i));
        }
    }

    @Test
    public void testSetY() {
        yval[1]=12;
        val.setY(1,12);
        for (int i=0;i< val.getCount();i++){
            Assert.assertEquals(yval[i],val.getY(i));
        }
    }

    @Test
    public void testLeftBound() {
        Assert.assertEquals(xval[0],val.leftBound());
    }

    @Test
    public void testRightBound() {
        Assert.assertEquals(xval[4],val.rightBound());
    }

    @Test
    public void testIndexOfX() {
        for (int i=1;i<6;i++){
            Assert.assertEquals(i-1,val.indexOfX(i));
        }
    }

    @Test
    public void testIndexOfY() {
        for (int i=1;i<6;i++){
            Assert.assertEquals(i-1,val.indexOfY(i));
        }
    }

    @Test
    public void testFloorIndexOfX() {
        for (int i =0;i<7;i++){
            if (i<1){
                Assert.assertEquals(0,val.floorIndexOfX(i));
            }
            else if (i>5){
                Assert.assertEquals(-1,val.indexOfX(i));
            }
            else{
                Assert.assertEquals(i-1,val.indexOfX(i));
            }
        }
    }

    @Test
    public void testExtrapolateLeft() {
        Assert.assertEquals(1.0,val.extrapolateLeft(1));
        Assert.assertEquals(2.0,val.extrapolateLeft(2));

    }

    @Test
    public void testExtrapolateRight() {
        Assert.assertEquals(1.0,val.extrapolateRight(1));
        Assert.assertEquals(2.0,val.extrapolateRight(2));
    }

    @Test
    public void testInterpolate() {
        Assert.assertEquals(1.0,val.interpolate(1,2));
        Assert.assertEquals(2.0,val.interpolate(2,2));
    }
}