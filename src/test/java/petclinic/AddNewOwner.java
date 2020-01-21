package petclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddNewOwner {

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
    public void AddNewOwnerTest() {
        driver.get("http://139.59.149.247:8000/petclinic/owners");

        WebElement addOwnerNewBtn = driver.findElement(By.cssSelector(".btn"));
        addOwnerNewBtn.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://139.59.149.247:8000/petclinic/owners/add", currentUrl);

        WebElement addOwnerBtn = driver.findElement(By.cssSelector(".btn[type='submit']"));
        assertFalse(addOwnerBtn.isEnabled());
    }

}
