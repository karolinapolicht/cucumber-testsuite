package pageO;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resource.Base;
import step.Hook;

public class LoginPage extends Base {

    public LoginPage(Hook hook) {
        super(hook.getDriver());
        PageFactory.initElements(hook.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement adressEmail;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    @FindBy(css = "a[class='logout']")
    private WebElement signOutBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement errorMessage;

    public void clickSubmit() {
        signInBtn.click();
    }

    public void enterEmail(String email) {
        adressEmail.sendKeys(email);
    }

    public void enterPassword(String passwd) {
        password.sendKeys(passwd);
    }

    public boolean presenceOfSignOut() {
      return isPresent(signOutBtn);
    }

    public void navToLogin() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    public void waitForAlert() {
        waitForVisibility(errorMessage);
    }

    public String getAlertMessage() {
        return errorMessage.getText();
    }

    public void verifyLogIn() {
        Assert.assertTrue(presenceOfSignOut());
    }

    public WebElement getAdressEmail() {
        return adressEmail;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement getSignOutBtn() {
        return signOutBtn;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
