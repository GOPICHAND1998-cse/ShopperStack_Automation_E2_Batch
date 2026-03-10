package testngPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DummyGroupExecutionClass1
{
    @Test(groups = "integration")
    public void m1()
    {
        Reporter.log("This is m1 method from class 1",true);
    }

    @Test(groups = "functionality")
    public void m2()
    {
        Reporter.log("This is m2 method from class 1",true);
    }

    @Test(groups = "regression")
    public void m3()
    {
        Reporter.log("This is m3 method from class 1",true);
    }
}
