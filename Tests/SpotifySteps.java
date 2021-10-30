package Tests;

import Pages.EndUserAgreementPage;
import Pages.HomePage;
import Pages.PremiumPage;
import Pages.SignupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SpotifySteps extends BaseTest {

    public HomePage homePage = new HomePage(driver);
    public PremiumPage premiumPage;
    public SignupPage signupPage;
    public EndUserAgreementPage endUserAgreementPage;

    @Given("the user is at Spotify homepage")
    public void the_user_is_at_spotify_homepage() {
        homePage.openHomepage();
    }

    @When("the user clicks on Premium Section")
    public void the_user_clicks_on_premium_section() {
        premiumPage = homePage.clickOnPremiumBtn();
    }

    @Then("the user should see a plan {string} available")
    public void the_user_should_see_a_plan_available(String planName) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(premiumPage.getPageTitle().contains("Premium"));
        Assert.assertTrue(premiumPage.isPlanDisplayed(planName), "Plan name doesn't match");
        premiumPage.closeBrowser();
    }

    @When("the user clicks on Registration section")
    public void the_user_clicks_on_registration_section() {
        signupPage = homePage.clickOnSignUpBtn();
    }

    @Then("the user should be on the registration page")
    public void the_user_should_be_on_the_registration_page() {
        Assert.assertTrue(signupPage.getPageTitle().contains("Registrarte"));
    }

    @When("the user clicks on the email field")
    public void the_user_clicks_on_the_email_field() {
        signupPage.clickOnEmailField();
    }

    @When("the user fills the {string} field")
    public void the_user_fills_the_field(String email) {
        signupPage.fillEmailField(email);
    }

    @When("the user clicks on the confirmation field")
    public void the_user_clicks_on_the_confirmation_field() {
        signupPage.clickOnConfirmationEmail();
    }

    @Then("the user should see an {string} message")
    public void the_user_should_see_an_message(String error) {
        Assert.assertTrue(signupPage.isErrorMsgDisplayed(error));
        signupPage.closeBrowser();
    }

    @When("the user navigates to the page {string}")
    public void the_user_navigates_to_the_page(String url) {
       endUserAgreementPage = homePage.navigateToPage(url);
    }

    @Then("the user should be on the en user agreement page")
    public void the_user_should_be_on_the_en_user_agreement_page() {
        Assert.assertTrue(endUserAgreementPage.getPageTitle().contains("Términos y Condiciones de Uso"));
    }

    @Then("the user should see the following {string}")
    public void the_user_should_see_the_following(String section) {
        Assert.assertTrue(endUserAgreementPage.isSectionDisplayed(section), "Section name doesn't match");
        endUserAgreementPage.closeBrowser();
    }



}
