package pageO;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import resource.Base;
import step.Hook;

public class ContactPage extends Base {

    private String SUCCESS_ALERT_MESS = "Your message has been successfully sent to our team.";
    private String CONTACT_HEADER = "Customer service - Contact us";

    public ContactPage(Hook hook) {
        super(hook.getDriver());
        PageFactory.initElements(hook.getDriver(), this);
    }


    public WebElement getContactHeader() {
        return contactHeader;
    }

    public WebElement getSubjectField() {
        return subjectField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getMessageBox() {
        return messageBox;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public WebElement getAlertTxt() {
        return alertTxt;
    }

    @FindBy(css = "h1[class='page-heading bottom-indent']")
    private WebElement contactHeader;

    @FindBy(id = "id_contact")
    private WebElement subjectField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "id_order")
    private WebElement orderReference;

    @FindBy(id = "message")
    private WebElement messageBox;

    @FindBy(id = "submitMessage")
    private WebElement sendBtn;

    @FindBy(css = "p[class='alert alert-success']")
    private WebElement alertTxt;

    public void contactHeaderVisibility() {
        waitForVisibility(contactHeader);
    }

    public void sendKeysMessage(String message) {
        messageBox.sendKeys(message);
    }

    public void alertVisibility() {
        waitForVisibility(alertTxt);
    }

    public void navContactPage() {
        driver.get("http://automationpractice.com/index.php?controller=contact");
    }

    public void fillInTheFields(String email, String orderRef) {
        Select subject = new Select(subjectField);
        subject.selectByIndex(1);
        emailField.sendKeys(email);
        orderReference.sendKeys(orderRef);
    }

    public void verifyMessageSent()  {
        alertVisibility();
        String successAlert = alertTxt.getText();
        Assert.assertEquals(SUCCESS_ALERT_MESS, successAlert);
    }

    public void verifyContactPageClicked() {
        contactHeaderVisibility();
        String contactHeaderTxt = contactHeader.getText();
        Assert.assertEquals(CONTACT_HEADER.toLowerCase(),contactHeaderTxt.toLowerCase());
    }
}