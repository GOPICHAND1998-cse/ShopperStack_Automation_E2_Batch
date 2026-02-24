package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import org.testng.annotations.Test;

public class PurchasingWatchUsingBaseClass extends PurchasingWatchBaseClass
{

    @Test
    public void clickOnElectronicLink()
    {
        try
        {
            actionUtil.clickOnElement(nav.getElectronicsLink());

            actionUtil.moveMouseToElement(nav.getShopperStackIcon());

            Thread.sleep(2000);

            browserUtil.refreshBrowser();

            actionUtil.scrollTillElement(home.getDesiredProd());

            actionUtil.clickOnElement(home.getDesiredProd());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
