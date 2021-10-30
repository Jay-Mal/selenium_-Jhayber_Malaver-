package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public HomePage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(xpath = "//*[@data-ga-action='premium']")
    public WebElement premiumBtn;

    @FindBy(xpath = "//*[@data-ga-action='sign-up']")
    public WebElement signupBtn;

    public void openHomepage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        PageFactory.initElements(driver, this);
    }

    public PremiumPage clickOnPremiumBtn() {
        premiumBtn.click();
        PremiumPage premiumPage = new PremiumPage(driver);
        return premiumPage;
    }

    public SignupPage clickOnSignUpBtn() {
        signupBtn.click();
        SignupPage signupPage = new SignupPage(driver);
        return signupPage;
    }

    public EndUserAgreementPage navigateToPage(String url){
        driver.navigate().to(url);
        EndUserAgreementPage endUserAgreementPage = new EndUserAgreementPage(driver);
        return endUserAgreementPage;
    }

}
