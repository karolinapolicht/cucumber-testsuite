package step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageO.LoginPage;

public class LoginStepDef {

    LoginPage loginPage;
    private Hook hook;

    public LoginStepDef(Hook hook, LoginPage loginPage) {
        this.hook = hook;
        this.loginPage = loginPage;
    }

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {
        loginPage.navToLogin();
    }


    @When("^user logs in with valid email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLogsInWithValidEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
    }

    @Then("^user sees Sign out at the top right hand corner of the screen$")
    public void userSeesSignOutAtTheTopRightHandCornerOfTheScreen() {
        loginPage.verifyLogIn();
    }


    @When("^user logs in with invalid e-mail \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLogsInWithInvalidEMailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
    }

    @Then("^user sees a message \"([^\"]*)\"$")
    public void userSeesAMessage(String message)  {
        Assert.assertEquals(message, loginPage.getAlertMessage());
    }

}
