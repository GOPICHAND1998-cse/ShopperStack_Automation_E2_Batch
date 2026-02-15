package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPagePOM
{
    @FindBy(xpath = "//input[@name='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='Login']")
    private WebElement logInButton;

    public LogInPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
