package functions;

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
}