package Pages.MainPage;

import Pages.AboutUsPage;
import Pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class FooterBlock extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='http://kuopassa.net/litecart/en/about-us-i-1']")
    private WebElement aboutUsLink;

    public FooterBlock(WebDriver driver) {
        super(driver);
    }

    public AboutUsPage goToAboutUsPage() {
        aboutUsLink.click();
        return new AboutUsPage(driver);
    }


}
