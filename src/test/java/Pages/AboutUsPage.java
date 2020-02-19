package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AboutUsPage extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/main/div/p[1]")
    private WebElement aboutUsText;


    public AboutUsPage(WebDriver driver){
        super(driver);
    }



}
