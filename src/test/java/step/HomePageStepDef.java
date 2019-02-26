package step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageO.CartPage;
import pageO.HomePage;

public class HomePageStepDef {

    WebDriver driver;
    HomePage homepage;
    CartPage cartPage;
    private Hook hook;

    public HomePageStepDef(Hook hook, HomePage homepage, CartPage cartPage) {
        this.hook = hook;
        this.homepage = homepage;
        this.cartPage = cartPage;
    }

    @Given("^The homepage is displayed$")
    public void theHomepageIsDisplayed() {
        homepage.navToHomePage();
        String storeTitle = driver.getTitle();
        Assert.assertEquals("My Store", storeTitle);
    }

    @Then("^Page should display (\\d+) categories in  menu$")
    public void pageShouldDisplayCategoriesInMenu(int count) {
        homepage.waitForMenu();
        Assert.assertEquals(count, homepage.getCategoriesSize());
    }

    @When("^The second category is chosen$")
    public void theSecondCategoryIsChosen() {
        homepage.hoverOver(homepage.dressField);
    }

    @Then("^The page from that category should display as expected$")
    public void thePageFromThatCategoryShouldDisplayAsExpected() {
        boolean hdr = cartPage.getHeader1().isDisplayed();
        Assert.assertTrue(hdr);
    }


}
