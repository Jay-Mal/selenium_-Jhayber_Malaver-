package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EndUserAgreementPage extends BasePage {

    public EndUserAgreementPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(tagName =  "a")
    public List<WebElement> aList;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isSectionDisplayed(String section) {
        boolean isDisplayed = false;
        for (WebElement a : aList) {
            if (a.getText().contains(section)) {
                isDisplayed = true;
                break;
            }
        }
        return isDisplayed;
    }

}
