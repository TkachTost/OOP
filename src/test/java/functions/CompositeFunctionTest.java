package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {

    SqrFunction f1=new SqrFunction();
    IdentityFunction f2=new IdentityFunction();
    CompositeFunction tst=new CompositeFunction(f1,f2);
    CompositeFunction tst2=new CompositeFunction(tst,f1);
    @Test
    public void testApply() {
        Assert.assertEquals(4.0,tst.apply(2));
        Assert.assertEquals(9.0,tst.apply(3));
        Assert.assertEquals(16.0,tst.apply(4));
        Assert.assertEquals(16.0,tst2.apply(2));
    }
}