package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "confirm")
    public WebElement confirmEmailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    public WebElement errorMsg;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnEmailField(){
        emailField.click();
    }

    public void fillEmailField(String email){
        emailField.sendKeys(email);
    }

    public void clickOnConfirmationEmail(){
        confirmEmailField.click();
    }

    public boolean isErrorMsgDisplayed(String error){
        return driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", error))).isDisplayed();
    }

}
