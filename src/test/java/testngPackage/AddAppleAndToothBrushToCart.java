package testngPackage;

import basePackage.ParallelMethodBaseClass;
import org.testng.annotations.Test;

public class AddAppleAndToothBrushToCart extends ParallelMethodBaseClass
{
    @Test
    public void addApple()
    {
        try
        {
            home.selectDesiredProduct("APPLE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
