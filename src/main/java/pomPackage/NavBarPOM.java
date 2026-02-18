package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPOM
{
    @FindBy(xpath = "//a[@id='home']")
    private WebElement shopperStackIcon;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[@id='men']")
    private WebElement menLink;

    @FindBy(xpath = "//a[@id='women']")
    private WebElement womenLink;

    @FindBy(xpath = "//a[@id='kids']")
    private WebElement kidsLink;

    @FindBy(xpath = "//a[@id='electronics']")
    private WebElement electronicsLink;

    @FindBy(xpath = "//a[@id='beautyProducts']")
    private WebElement beautyLink;

    public NavBarPOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getShopperStackIcon() {
        return shopperStackIcon;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public WebElement getMenLink() {
        return menLink;
    }

    public WebElement getWomenLink() {
        return womenLink;
    }

    public WebElement getKidsLink() {
        return kidsLink;
    }

    public WebElement getElectronicsLink() {
        return electronicsLink;
    }

    public WebElement getBeautyLink() {
        return beautyLink;
    }
}
