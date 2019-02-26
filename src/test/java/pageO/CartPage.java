package pageO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resource.Base;
import step.Hook;

public class CartPage extends Base {

    @FindBy(id = "product_price_2_7_0")
    private WebElement unitPrice;

    @FindBy(id = "total_product_price_2_7_0")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]/span")
    private WebElement itemBlouse;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedBtn;

    @FindBy(id = "cart_quantity_up_2_7_0_0")
    private WebElement quantityBtn;

    @FindBy(css = "button[name='Submit']")
    private WebElement submitBtn;

    @FindBy(css = "a[title='View my shopping cart']")
    private WebElement basketIcon;

    @FindBy(xpath = "//tr[@id='product_1_1_0_0']/td[2]/p/a")
    private WebElement description;

    @FindBy(css = "span[title='Continue shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//li[contains(text(), 'Printed Summer')][1]")
    private WebElement firstItemInSearch;

    @FindBy(name = "Submit")
    private WebElement submitItemToCartBtn;

    @FindBy(css = "a[title='Proceed to checkout")
    private WebElement proceedToCheckoutBtn;

    @FindBy(className = "navigation_page")
    private WebElement summarypNavHeader;

    @FindBy(className = "cat-name")
    private WebElement header1;

    @FindBy(xpath= "//input[@name='quantity_2_7_0_0' and @class='cart_quantity_input form-control grey']")
    private WebElement blouseQuantity;

    public WebElement getBlouseQuantity() {
        return blouseQuantity;
    }


    public WebElement getHeader1() {
        return header1;
    }


    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getBasketIcon() {
        return basketIcon;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getContinueShoppingBtn() {
        return continueShoppingBtn;
    }

    public WebElement getFirstItemInSearch() {
        return firstItemInSearch;
    }

    public WebElement getSubmitItemToCartBtn() {
        return submitItemToCartBtn;
    }

    public WebElement getProceedToCheckoutBtn() {
        return proceedToCheckoutBtn;
    }

    public WebElement getSummarypNavHeader() {
        return summarypNavHeader;
    }


    public CartPage(Hook hook) {
        super(hook.getDriver());
        PageFactory.initElements(hook.getDriver(), this);
    }

    public WebElement waitForTotalPriceChangeTo(String totalPrice) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='" + totalPrice + "' and @id='total_product_price_2_7_0']")));
    }

    public void waitForContinueShoppingBtn() {
        waitForClickable(continueShoppingBtn);
    }

    public void waitForProceed() {
        waitForClickable(proceedBtn);
    }

    public void waitForUnitPrice() {
        waitForVisibility(unitPrice);
    }

    public void clickOnSubmitBtn() {
        clickOn(submitItemToCartBtn);
    }

    public void clickOnProceed() {
        clickOn(proceedToCheckoutBtn);
    }

    public void waitForNavHeader() {
        waitForVisibility(summarypNavHeader);
    }

    public void clickOnFirstItem() {
        clickOn(firstItemInSearch);
    }

    public void clickOnItemWithName(String itemName) {
        driver.findElement(By.xpath("//li[contains(text(), '" + itemName + "')][1]")).click();
    }


    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getItemBlouse() {
        return itemBlouse;
    }

    public WebElement getProceedBtn() {
        return proceedBtn;
    }

    public WebElement getQuantityBtn() {
        return quantityBtn;
    }
}
