package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {

    SqrFunction f1=new SqrFunction();
    IdentityFunction f2=new IdentityFunction();
    CompositeFunction tst=new CompositeFunction(f1,f2);
    @Test
    public void testApply() {
        Assert.assertEquals(4.0,f2.apply(f1.apply(2)));
        Assert.assertEquals(9.0,f2.apply(f1.apply(3)));
        Assert.assertEquals(16.0,f2.apply(f1.apply(4)));
    }
}