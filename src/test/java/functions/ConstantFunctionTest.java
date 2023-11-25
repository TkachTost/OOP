package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {

    ConstantFunction tst=new ConstantFunction(15.0);

    @Test
    public void testApply() {
        Assert.assertEquals(15.0,tst.apply(1));
        Assert.assertEquals(15.0,tst.apply(-1));
        Assert.assertEquals(15.0,tst.apply(1.1));
        Assert.assertEquals(15.0,tst.apply(-1.1));
    }
}