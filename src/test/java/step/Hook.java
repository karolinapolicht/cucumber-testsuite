package step;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    private static boolean initialize = false;
    private WebDriver driver;

    @Before
    public void initializeTest() {
        System.out.println("Opening the browser: Chrome\n");
        if (!initialize) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karcina\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            initialize = true;
        }
    }

    public WebDriver getDriver() {
    return driver;
    }

    @After
    public void tearDownTest() {
        initialize = false;
        driver.quit();
        System.out.println("Closing the browser \n");
    }
}
