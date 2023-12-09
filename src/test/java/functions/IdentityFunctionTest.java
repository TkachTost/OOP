package functions;

import javafx.scene.chart.AxisBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class IdentityFunctionTest {

    IdentityFunction tst=new IdentityFunction();
    @Test
    public void testApply() {
        Assert.assertEquals(5.0,tst.apply(5));
        Assert.assertEquals(-5.0,tst.apply(-5));
        Assert.assertEquals(1.1,tst.apply(1.1));
        Assert.assertEquals(-1.1,tst.apply(-1.1));
    }

    @Test
    public void testTestToString() {
        Assert.assertEquals("class: IdentityFunction",tst.toString());
    }

    IdentityFunction tst1=new IdentityFunction();
    SqrFunction tst2=new SqrFunction();
    @Test
    public void testTestEquals() {
        Assert.assertEquals(true,tst.equals(tst1));
        Assert.assertEquals(false,tst.equals(tst2));
    }

    @Test
    public void testTestHashCode() {
        Assert.assertEquals(0x1503,tst.hashCode());
    }

    @Test
    public void testTestClone() throws CloneNotSupportedException {
        IdentityFunction cl= (IdentityFunction) tst.clone();
        Assert.assertTrue(tst.equals(cl));
    }
}