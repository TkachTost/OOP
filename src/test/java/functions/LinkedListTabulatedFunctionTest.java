package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.soap.Node;

public class LinkedListTabulatedFunctionTest implements Cloneable{
    private double[] xval={1,2,3,4,5};
    private double[] yval={1,2,3,4,5};
    LinkedListTabulatedFunction list=new LinkedListTabulatedFunction(xval,yval);
    @Test
    public void toStringTest(){
        for(int i=0;i<5;i++){
            Assert.assertEquals("("+xval[i]+"; "+yval[i]+")",list.getNodep(i).toString());
        }
    }
    LinkedListTabulatedFunction o=new LinkedListTabulatedFunction(xval,yval);
    @Test
    public void equalsTest(){
        for(int i=0;i<5;i++){
            Assert.assertTrue(list.getNodep(i).equals(o.getNodep(i)));
        }
    }
    @Test
    public void testLeftBound() {
        Assert.assertEquals(xval[0],list.leftBound());
    }
    @Test
    public void hashCodeTest(){
        for(int i=0;i<5;i++){
            Assert.assertEquals(i+1^i+1,list.getNodep(i).hashCode());
        }
    }
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        for (int i=0;i<5;i++){
            functions.LinkedListTabulatedFunction.Node cl = (LinkedListTabulatedFunction.Node) list.getNodep(i).clone();
            Assert.assertEquals(list.getNodep(i).toString(),cl.toString());

        }
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
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetXEx() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.getX(-1);
        llist.getX(llist.getCount());
    }
    @Test
    public void testGetY() {
        for (int i=0;i<5;i++){
            Assert.assertEquals(yval[i],list.getY(i));
        }
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetYEx() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.getY(-1);
        llist.getY(llist.getCount());
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
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetYEx() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.setY(-1,14);
        llist.setY(llist.getCount(),14);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIndexOfXEx() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.indexOfX(-1);
        llist.indexOfX(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIndexOfYEx() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.indexOfY(-1);
        llist.indexOfY(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFloorIndexOfXEx() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.floorIndexOfX(-1);
    }
    @Test
    public void testInterpolate() {
        Assert.assertEquals(2.5,list.interpolate(2.5,1));
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInterpolateEx(){
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        llist.interpolate(12,-1);
        llist.interpolate(12,5);
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

    @Test
    public void testTestToString() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        Assert.assertEquals("1.0 2.0 3.0 4.0 5.0 1.0 2.0 3.0 4.0 5.0 ",llist.toString());

    }
    @Test
    public void testTestEquals() {
        double[] xxval={1,2,3,4,5};
        double[] yyval={1,2,3,4,5};
        LinkedListTabulatedFunction llist=new LinkedListTabulatedFunction(xxval,yyval);
        Assert.assertTrue(llist.equals(o));
    }

    @Test
    public void testTestHashCode() {
        int hash = 0;
        for (int i = 0; i < 5; i++) {
            hash += Double.hashCode(xval[i]) ^ Double.hashCode(yval[i]);
        }
        Assert.assertEquals(hash,list.hashCode());
    }

    @Test
    public void testTestClone () throws CloneNotSupportedException {
        LinkedListTabulatedFunction o= (LinkedListTabulatedFunction) list.clone();
        for (int i=0;i<5;i++){
            Assert.assertEquals(list.getX(i),o.getX(i));
        }
    }
    @Test(expectedExceptions = DifferentLengthOfArraysException.class)
    public void LincEx1(){
        double[] arr1=new double[]{1,2,3};
        double[] arr2=new double[]{1,2,3,4,5};
        LinkedListTabulatedFunction list1=new LinkedListTabulatedFunction(arr1,arr2);
    }
    @Test(expectedExceptions = ArrayIsNotSortedException.class)
    public void LincEx2(){
        double[] arr1=new double[]{1,2,3,5,4};
        double[] arr2=new double[]{5,4,3,2,1};
        LinkedListTabulatedFunction list2=new LinkedListTabulatedFunction(arr1,arr2);
    }
}