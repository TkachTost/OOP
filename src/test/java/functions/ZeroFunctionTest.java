package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {
    ZeroFunction tst=new ZeroFunction();
    @Test
    public void testApply(){
        Assert.assertEquals(0.0,tst.apply(12));
        Assert.assertEquals(0.0,tst.apply(-12));
        Assert.assertEquals(0.0,tst.apply(0));
        Assert.assertEquals(0.0,tst.apply(1.1));

    }

}