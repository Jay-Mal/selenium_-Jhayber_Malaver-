package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PremiumPage extends BasePage {

    public PremiumPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(tagName =  "h3")
    public List<WebElement> h3List;

    public boolean isPlanDisplayed(String planName) {
        boolean isDisplayed = false;
        for (WebElement h3 : h3List) {
            if (h3.getText().contains(planName)) {
                isDisplayed = true;
                break;
            }
        }
        return isDisplayed;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


}
