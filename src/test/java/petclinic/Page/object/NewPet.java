package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import petclinic.model.Pet;

public class NewPet {
    private WebDriver driver;

    public NewPet(WebDriver driver) {
        this.driver = driver;
    }

    public void fillVet(Pet pet) {
        setPetName(pet.getName());
        setPetBirthDate(pet.getBirthDate());
        setPetType(pet.getType());
    }

    public void setPetName(String petName) {
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(petName);
    }

    public void setPetBirthDate(String petBirthDate) {
        WebElement birthDate = driver.findElement(By.cssSelector("input[name=\"birthDate\"]"));
        birthDate.clear();
        birthDate.sendKeys(petBirthDate);
    }

    public void setPetType(String type) {
        WebElement typeField = driver.findElement(By.id("type"));
        Select typeSelector = new Select(typeField);
        typeSelector.selectByVisibleText(type);
    }

    public OwnerInformationPage clickSavePetButton(){
        WebElement savePetBtn = driver.findElement(By.xpath("//*[text()='Save Pet']"));
        savePetBtn.click();
        return new OwnerInformationPage(driver);
    }
}
