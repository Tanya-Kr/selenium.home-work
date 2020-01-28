package petclinic.Page.object;
import org.openqa.selenium.Keys;
import petclinic.model.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewOwnerPage {
    private WebDriver driver;

    private WebElement firstNameField() {
        return driver.findElement(By.id("firstName"));
    }

    private By lastNameInputField = By.id("lastName");

    public NewOwnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOwner(Owner owner) {
        setFirstName(owner.getFirstName());
        setLastName(owner.getLastName());
        setAddress(owner.getAddress());
        setCity(owner.getCity());
        setTelephone(owner.getTelephone());
    }

    public void setFirstName(String firstName) {
        WebElement name = firstNameField();
        name.clear();
        name.sendKeys(firstName);
    }

    public void clearFirstName() {
        WebElement name = firstNameField();
        name.sendKeys(Keys.CONTROL + "a");
        name.sendKeys(Keys.DELETE);
    }

    public void setLastName(String lastName) {
        WebElement lastNameField = driver.findElement(lastNameInputField);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clearLastName() {
        WebElement lastNameField = driver.findElement(lastNameInputField);
        lastNameField.sendKeys(Keys.CONTROL + "a");
        lastNameField.sendKeys(Keys.DELETE);
    }

    public void setAddress(String address) {
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clearAddress() {
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys(Keys.CONTROL + "a");
        addressField.sendKeys(Keys.DELETE);
    }

    public void setCity(String city) {
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void clearCity() {
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys(Keys.DELETE);
    }

    public void setTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(By.id("telephone"));
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    public void clearTelephone() {
        WebElement telephoneField = driver.findElement(By.id("telephone"));
        telephoneField.sendKeys(Keys.CONTROL + "a");
        telephoneField.sendKeys(Keys.DELETE);
    }

    public OwnersPage clickAddOwnerButton() {
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Add Owner']"));
        addOwnerBtn.click();
        return new OwnersPage(driver);
    }


}
