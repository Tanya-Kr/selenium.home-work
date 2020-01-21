package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewVeterinarianPage {
    private WebDriver driver;

    private By lastNameInputField = By.id("lastName");

    public NewVeterinarianPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setFirstName(String firstName) {
//        WebElement name = firstNameField();
//        name.clear();
//        name.sendKeys(firstName);
    }

    public void clearFirstName() {
//        WebElement name = firstNameField();
//        name.clear();
    }

    public void setLastName(String lastName) {
        WebElement lastNameField = driver.findElement(lastNameInputField);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clearLastName() {
        WebElement lastNameField = driver.findElement(lastNameInputField);
        lastNameField.clear();
    }
}
