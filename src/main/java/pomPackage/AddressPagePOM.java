package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPagePOM
{
    @FindBy(xpath = "//button[contains(.,'Add New Address')]")
    private WebElement newAddressButton;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement addressRadioButton;

    @FindBy(xpath = "//button[text()='Proceed']")
    private WebElement proceedButton;


    public AddressPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getNewAddressButton() {
        return newAddressButton;
    }

    public WebElement getAddressRadioButton() {
        return addressRadioButton;
    }

    public WebElement getProceedButton() {
        return proceedButton;
    }
}
