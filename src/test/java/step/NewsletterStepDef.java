package step;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageO.HomePage;
import pageO.NewsletterPage;

public class NewsletterStepDef {

    HomePage homepage;
    NewsletterPage newsletterPage;
    private Hook hook;

    public NewsletterStepDef(Hook hook, HomePage homePage, NewsletterPage newsletterPage) {
        this.hook = hook;
        this.homepage = homePage;
        this.newsletterPage = newsletterPage;
    }

    @When("^User enters valid e-mail \"([^\"]*)\"$")
    public void userEntersValid(String email) {
        homepage.newsletterField.sendKeys(email);
        homepage.newsletterBtn.click();
    }

    @Then("^User receives feedback that the newsletter is already subscribed$")
    public void userReceivesFeedbackThatTheNewsletterIsAlreadySubscribed() {
        Assert.assertEquals("Newsletter : This email address is already registered.", newsletterPage.getAlertText());
    }



}
