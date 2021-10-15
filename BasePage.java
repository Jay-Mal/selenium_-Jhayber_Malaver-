package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

}
