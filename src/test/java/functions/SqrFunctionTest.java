package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {

    SqrFunction tst=new SqrFunction();
    @Test
    public void testApply() {
        Assert.assertEquals(25.0,tst.apply(5));
        Assert.assertEquals(25.0,tst.apply(-5));
        Assert.assertEquals(6.25,tst.apply(2.5));
        Assert.assertEquals(6.25,tst.apply(-2.5));

    }
}