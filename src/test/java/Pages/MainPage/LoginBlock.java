package Pages.MainPage;

import Pages.BasePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/aside/div/div[2]/div[2]/form/div[1]/div/input")
    private WebElement loginField;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/aside/div/div[2]/div[2]/form/div[2]/div/input")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/aside/div/div[2]/div[2]/form/div[3]/button")
    private WebElement signInButton;

    public LoginBlock(WebDriver driver){
        super(driver);
    }

    public LoginPage logInToSite(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return new LoginPage(driver);
    }
}
