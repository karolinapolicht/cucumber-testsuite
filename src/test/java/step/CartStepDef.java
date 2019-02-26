package step;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageO.CartPage;
import pageO.HomePage;

public class CartStepDef {

    private String SUMMARY_PAGE_NAV_HEADER = "Your shopping cart";
    CartPage cartpage;
    HomePage homepage;

    private Hook hook;

    public CartStepDef(Hook hook, CartPage cartPage, HomePage homePage) {
        this.hook = hook;
        this.homepage = homePage;
        this.cartpage = cartPage;
    }

    @When("^User adds item to the cart$")
    public void userAddsItemToTheCart() {
        homepage.clickOnFirstItem();
        cartpage.getSubmitBtn().click();
        cartpage.waitForContinueShoppingBtn();
        cartpage.getContinueShoppingBtn().click();
    }

    @And("^User clicks the basket icon$")
    public void userClicksTheBasketIcon() {
        cartpage.getBasketIcon().click();
    }

    @Then("^The shopping cart summary is displayed$")
    public void theShoppingCartSummaryIsDisplayed() {
        Assert.assertTrue(homepage.presenceOfSummaryHeader());

    }

    @And("^User sees the product in cart$")
    public void userSeesTheProductInCart() {
    Assert.assertEquals("Faded Short Sleeve T-shirts", cartpage.getDescription().getText());
    }


    @When("^User enters a \"([^\"]*)\" in a search box$")
    public void userEntersAInASearchBox(String item) throws Throwable {
        homepage.sendKeys(homepage.searchField, item);
        homepage.waitForDressContainer();
    }

    @And("^User picks \"([^\"]*)\"$")
    public void userPicks(String item) throws Throwable {
       cartpage.clickOnItemWithName(item);
    }

    @And("^User adds item to cart$")
    public void userAddsItemToCart() {
        cartpage.clickOnSubmitBtn();

    }

    @And("^User proceeds to checkout$")
    public void userProceedsToCheckout() {
        cartpage.clickOnProceed();

    }

    @Then("^User cart should display with added item$")
    public void userCartShouldDisplayWithAddedItem() {
       cartpage.waitForNavHeader();
        String navText = cartpage.getSummarypNavHeader().getText();
        Assert.assertEquals(SUMMARY_PAGE_NAV_HEADER, navText);
    }


    @When("^User adds item \"([^\"]*)\" to cart with price \"([^\"]*)\"$")
    public void userAddsItemToCartWithPrice(String item, String price)  {
        cartpage.waitForClickable(cartpage.getItemBlouse());
        cartpage.getItemBlouse().click();
        cartpage.waitForProceed();
        cartpage.getProceedBtn().click();
        cartpage.waitForUnitPrice();
        String unitPriceTxt = cartpage.getUnitPrice().getText();
        Assert.assertEquals(price, unitPriceTxt);

    }

    @And("^User increases quantity of the product$")
    public void userIncreasesQuantityOfTheProduct() {
        cartpage.getQuantityBtn().click();
    }

    @Then("^The total price is increased to \"([^\"]*)\"$")
    public void theTotalPriceIsIncreasedTo(String totalPrice) {
        String increasedTotalPriceTxt = cartpage.waitForTotalPriceChangeTo(totalPrice).getText();
        Assert.assertEquals(totalPrice, increasedTotalPriceTxt);
    }

    @And("^The number of items in the basket should be \"([^\"]*)\"$")
    public void theNumberOfItemsInTheBasketShouldBe(String totQuantity)  {
        Assert.assertEquals(totQuantity, cartpage.getBlouseQuantity().getAttribute("value"));

    }
}
