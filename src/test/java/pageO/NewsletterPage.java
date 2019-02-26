package pageO;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resource.Base;
import step.Hook;

public class NewsletterPage extends Base {

    public NewsletterPage(Hook hook) {
        super(hook.getDriver());
        PageFactory.initElements(hook.getDriver(), this);
    }

    @FindBy(css = "p[class='alert alert-danger']")
    private WebElement dangerAlert;

    public void waitForAlert() {
        waitForVisibility(dangerAlert);
    }

    public String getAlertText() {
       String alertTxt = dangerAlert.getText();
       return alertTxt;
    }
}
