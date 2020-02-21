package Pages.MainPage;

import Pages.BasePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@name='login']")
    private WebElement signInButton;

    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    public LoginPage logInToSite(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return new LoginPage(driver);
    }
}
