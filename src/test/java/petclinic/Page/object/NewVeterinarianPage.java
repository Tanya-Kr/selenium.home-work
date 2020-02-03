package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import petclinic.model.Vet;

public class NewVeterinarianPage {
    private WebDriver driver;

    private By firstNameInputField = By.id("firstName");

    private By lastNameInputField = By.id("lastName");

    public NewVeterinarianPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillVet(Vet vet) {
        setFirstName(vet.getFirstName());
        setLastName(vet.getLastName());
    }

    public void setFirstName(String firstName) {
        WebElement name = driver.findElement(firstNameInputField);
        name.clear();
        name.sendKeys(firstName);
    }

    public void clearFirstName() {
        WebElement name = driver.findElement(firstNameInputField);
        name.clear();
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

    public void setType() {
        WebElement typeField = driver.findElement(By.id("specialties"));
        Select typeSelector = new Select(typeField);
        typeSelector.selectByIndex(1);
    }

    public VeterinariansPage clickAddVetButton(){
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Save Vet']"));
        addOwnerBtn.click();
        return new VeterinariansPage(driver);
    }
}
