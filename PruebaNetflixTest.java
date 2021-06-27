import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {

    public WebDriver driver;
    Faker faker = new Faker();

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void iniciarSesionPageTest() {
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        WebElement h1Title = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(h1Title.getText(), "Sign In");

        WebElement fbLogin = driver.findElement(By.className("fbBtnText"));
        Assert.assertTrue(fbLogin.isDisplayed());
    }

    @Test
    public void fakeEmailTest() {
        driver.findElement(By.xpath("//input[@id='id_email_hero_fuji']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-uia='our-story-cta-hero_fuji']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Test(dataProvider = "userEmail", dataProviderClass = dataProvider.class)
    public void dataProviderEmailTest(String email) {
        driver.findElement(By.xpath("//input[@id='id_email_hero_fuji']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@data-uia='our-story-cta-hero_fuji']")).click();
    }

    @Test
    @Parameters({"specificTag"})
    public void printTagsTest(@Optional("h2") String tagName) {
        List<WebElement> tagList = driver.findElements(By.tagName(tagName));

        for (WebElement tag : tagList) {
            System.out.println(tag.getText());
        }
    }

    @AfterMethod
    public void closeTest() {
        driver.close();
    }
}
