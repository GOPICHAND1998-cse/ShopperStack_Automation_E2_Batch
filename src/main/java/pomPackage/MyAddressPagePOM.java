package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAddressPagePOM
{
    @FindBy(xpath = "//button[text()='Add Address']")
    private WebElement addAddressButton;

    @FindBy(xpath = "//div[@class='addressListContainer']/child::div")
    private List<WebElement> addressCards;

   public MyAddressPagePOM(WebDriver driver)
   {
       PageFactory.initElements(driver,this);
   }

    public WebElement getAddAddressButton() {
        return addAddressButton;
    }

    public List<WebElement> getAddressCards() {
        return addressCards;
    }
}
