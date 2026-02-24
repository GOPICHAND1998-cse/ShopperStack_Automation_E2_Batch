package testngPackage;

import org.testng.Reporter;
import org.testng.annotations.*;

public class UnderstandingOrderOfExecution
{
    @BeforeSuite
    public void beforeSuite()
    {
        Reporter.log("This is Before Suite",true);
    }

    @BeforeTest
    public void beforeTest()
    {
        Reporter.log("This is Before Test",true);
    }

    @BeforeClass
    public void beforeClass()
    {
        Reporter.log("This is Beforew Class",true);
    }

    @BeforeMethod
    public void beforeMethod()
    {
        Reporter.log("This is Before Method",true);
    }

    @Test
    public void test1()
    {
        Reporter.log("This is Test 1 Method",true);
    }

    @Test
    public void test2()
    {
        Reporter.log("This is Test 2 Method",true);
    }

    @AfterMethod
    public void afterMethod()
    {
        Reporter.log("This is After Method",true);
    }

    @AfterClass
    public void afterClass()
    {
        Reporter.log("This is After Class",true);
    }

    @AfterTest
    public void afterTest()
    {
        Reporter.log("This is After Test",true);
    }

    @AfterSuite
    public void afterSuite()
    {
        Reporter.log("This is After Suite",true);
    }
}
