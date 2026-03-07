package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import listenerPackage.CustomListener;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PurchasingWatchUsingSoftAssertion extends PurchasingWatchBaseClass
{
    WebDriver driver;

    @Test
    public void openHomepage()
    {
        driver = browserUtil.getDriver();

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/user-signin","The LogIn Unsuccessful");
        Reporter.log("The LogIn is Successful",true);
        sAssert.assertAll();
    }

    @Test
    public void selectDesiredProduct()
    {
        SoftAssert sAssert = new SoftAssert();

        actionUtil.scrollTillElement(home.getDesiredProd());
        sAssert.assertTrue(home.getDesiredProd().isDisplayed(),"The DesiredProduct is not displayed");
        Reporter.log("The desired Product is displayed",true);
        actionUtil.clickOnElement(home.getDesiredProd());

        try{Thread.sleep(2000);} catch (Exception e) {
            e.printStackTrace();
        }
        sAssert.assertAll();
    }

    @Test
    public void AddTocart()
    {
        SoftAssert sAssert = new SoftAssert();

        jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
        sAssert.assertEquals(product.getaddToCartBtn().getText().toLowerCase(),"added","The Product is not added to Cart");
        Reporter.log("The product is added to Cart",true);

        sAssert.assertAll();
    }



}
