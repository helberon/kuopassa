package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AboutUsPage extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//h1[text()='About Us']/following-sibling::p[1]")
    private WebElement aboutUsText;


    public AboutUsPage(WebDriver driver){
        super(driver);
    }



}
