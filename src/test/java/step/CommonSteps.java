package step;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import pageO.HomePage;

public class CommonSteps {

    HomePage homepage;

    private Hook hook;

    public CommonSteps(Hook hook, HomePage homepage) {
        this.hook = hook;
        this.homepage = homepage;
    }

    @Given("^User goes to the e-shop home page$")
    public void userGoesToTheEShopHomePage() {
        homepage.navToHomePage();
        String storeTitle = hook.getDriver().getTitle();
        Assert.assertEquals("My Store", storeTitle);
    }
}
