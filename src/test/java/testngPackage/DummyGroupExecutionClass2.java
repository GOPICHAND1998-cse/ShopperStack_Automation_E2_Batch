package testngPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DummyGroupExecutionClass2
{
    @Test(groups = {"regression","functionality"})
    public void m4()
    {
        Reporter.log("This is m4 method from class 2",true);
    }

    @Test(groups = {"integration","functionality"})
    public void m5()
    {
        Reporter.log("This is m5 method from class 2",true);
    }

    @Test(groups = "regression")
    public void m6()
    {
        Reporter.log("This is m6 method from class 2",true);
    }
}
