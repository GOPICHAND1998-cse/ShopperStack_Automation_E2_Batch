package testngPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTestNGExecution
{
    @Test
    public void logIn()
    {
        Reporter.log("LogIn is successful",true);
    }

    @Test(priority =2)
    public void friendRequest()
    {
        Reporter.log("The friendRequest is sent",true);
    }

    @Test(priority =3)
    public void notification()
    {
        Reporter.log("The notification is visible",true);
    }
}
