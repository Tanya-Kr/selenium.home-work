package SeleniumDevTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SeleniumUiTest {

    private WebDriver driver;

    private static final String BASE_URL = "https://selenium.dev";

    @BeforeClass
    public  void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openSeleniumUrlTest() {

        checkPage(BASE_URL + "/" , "SeleniumHQ Browser Automation");
        checkPage(BASE_URL + "/downloads/", "Downloads");
        checkPage(BASE_URL + "/projects/", "Selenium Projects");
        checkPage(BASE_URL + "/documentation/en/", "The Selenium Browser Automation Project :: Documentation for Selenium");
        checkPage(BASE_URL + "/support/", "Selenium Support");
        checkPage(BASE_URL + "/blog/", "Selenium Blog");
    }


    private void checkPage(String pageUrl, String pageTitle) {

        driver.get(pageUrl);

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, pageUrl, "Wrong url");

        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, pageTitle, "Wrong page title");
    }
}
