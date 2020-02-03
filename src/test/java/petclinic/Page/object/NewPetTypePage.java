package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class NewPetTypePage {

    private WebDriver driver;

    public NewPetTypePage (WebDriver driver) {this.driver = driver;}

    public void setPetType (String petType) {
        WebElement petTypeField = driver.findElement(By.id("name"));
        petTypeField.clear();
        petTypeField.sendKeys(petType);
    }

    public PetTypesPage clickSavePetTypeButton() {
        WebElement savePetTypeBtn = driver.findElement(By.xpath("//*[normalize-space(text())='Save']"));
        savePetTypeBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.invisibilityOf(savePetTypeBtn));
        boolean isStalenessOfSaveButton = wait.until(ExpectedConditions.stalenessOf(savePetTypeBtn));
        assertTrue(isStalenessOfSaveButton, "Name field still displayed!");

        return new PetTypesPage(driver);
    }
}
