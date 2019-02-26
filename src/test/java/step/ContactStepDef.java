package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageO.ContactPage;
import pageO.HomePage;

public class ContactStepDef {

    HomePage homepage;
    ContactPage contactpage;
    private Hook hook;

    public ContactStepDef(Hook hook, ContactPage contactPage, HomePage homePage) {
        this.hook = hook;
        this.homepage = homePage;
        this.contactpage = contactPage;
    }

    @Given("^User is on the homepage$")
    public void userIsOnTheHomepage() {
        homepage.navToHomePage();
    }

    @When("^User selects Contact us from the menu$")
    public void userSelectsContactUsFromTheMenu() {
        homepage.contactLinkVisibility();
        homepage.contactLink.click();
    }

    @Then("^Contact us page is displayed$")
    public void contactUsPageIsDisplayed() {
        contactpage.verifyContactPageClicked();
    }

    @Given("^User is on the Contact us page$")
    public void userIsOnTheContactUsPage() {
        contactpage.navContactPage();
    }

    @And("^User enters valid data$")
    public void userEnterValidData() {
        contactpage.fillInTheFields("jose@yah.com", "complaint");
    }

    @And("^User writes \"([^\"]*)\" in message field$")
    public void userWritesInMessageField(String message)  {
        contactpage.sendKeysMessage(message);
    }

    @When("^User clicks Send button$")
    public void userClickSendButton() {
        contactpage.getSendBtn().click();
    }

    @Then("^User receives feedback that message was sent$")
    public void userReceiveFeedbackThatMessageWasSent() {
        contactpage.verifyMessageSent();
    }


}
