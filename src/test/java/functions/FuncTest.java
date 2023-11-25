package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FuncTest {

    Func tst=new Func();

    @Test
    public void testApply() {
        tst.a=2;
        Assert.assertEquals(4.0,tst.apply(4));
        Assert.assertEquals(1.21,tst.apply(1.21));
        Assert.assertEquals(1.331,tst.apply(1.331));
    }
}