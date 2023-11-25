package functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    UnitFunction tst=new UnitFunction();
    @Test
    public void TestApply(){
        Assert.assertEquals(1.0,tst.apply(12));
        Assert.assertEquals(1.0,tst.apply(-12));
        Assert.assertEquals(1.0,tst.apply(0));
        Assert.assertEquals(1.0,tst.apply(1.1));
    }

}