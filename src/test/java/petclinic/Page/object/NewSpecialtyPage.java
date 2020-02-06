package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import petclinic.model.Specialty;


import static org.testng.Assert.assertTrue;

public class NewSpecialtyPage {

    private WebDriver driver;

    public NewSpecialtyPage(WebDriver driver) {this.driver = driver;}

    private By saveSpecialtyButton = By.xpath("//*[normalize-space(text())='Save']");

    public void fillSpecialty(Specialty specialty) {
        setSpecialty(specialty.getName());

    }

    public void setSpecialty (String specialty) {
        WebElement SpecialtyField = driver.findElement(By.id("name"));
        SpecialtyField.clear();
        SpecialtyField.sendKeys(specialty);
    }


    public SpecialtyPage clickSaveSpecialtyBtn() {
        WebElement saveSpecialtyBtn = driver.findElement(saveSpecialtyButton);
        saveSpecialtyBtn.click();

        return new SpecialtyPage(driver);
    }

    public SpecialtyPage waitClickSaveSpecialtyBtn() {
        WebElement saveSpecialtyBtn = driver.findElement(saveSpecialtyButton);
        saveSpecialtyBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.invisibilityOf(saveSpecialtyBtn));
        boolean isStalenessOfSaveButton = wait.until(ExpectedConditions.stalenessOf(saveSpecialtyBtn));
        assertTrue(isStalenessOfSaveButton, "Name field still displayed!");

        return new SpecialtyPage(driver);
    }
}
