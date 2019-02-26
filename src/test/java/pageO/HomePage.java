package pageO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resource.Base;
import step.Hook;

public class HomePage extends Base {

    public HomePage(Hook hook) {
        super(hook.getDriver());
        PageFactory.initElements(hook.getDriver(), this);
    }

    @FindBy(css = "button[name='submitNewsletter']")
    public WebElement newsletterBtn;

    @FindBy(id = "newsletter-input")
    public WebElement newsletterField;

    @FindBy(id = "contact-link")
    public WebElement contactLink;

    @FindBy(id = "cart_title")
    public WebElement summaryHeader;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]/div/div/div/a[1]/img")
    public WebElement firstItem;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    public WebElement dressField;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li/a")
    public WebElement eveningDressField;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    public WebElement logo;

    @FindBy(id = "block_top_menu")
    public WebElement categories;

    @FindBy(id = "search_query_top")
    public WebElement searchField;

    @FindBy(className = "ac_results")
    public WebElement dressContainer;


    public void clickOnFirstItem() {
        clickOn(firstItem);
    }

    public boolean presenceOfSummaryHeader() {
        return isPresent(summaryHeader);
    }

    public void contactLinkVisibility() {
        waitForVisibility(contactLink);
    }

    public void navToHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public int getCategoriesSize() {
        return driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li")).size();
    }

    public void waitForDressContainer() {
        waitForVisibility(dressContainer);
    }

    public void waitForMenu() {
        waitForVisibility(categories);
    }

    public void hoverOver(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).click().build().perform();
    }
}


