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

            jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Test
    public void addToothBrush()
    {
        try
        {
            home.selectDesiredProduct("ORAL B");

            jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
