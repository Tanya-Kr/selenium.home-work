package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petclinic.model.Specialty;


import java.util.ArrayList;
import java.util.List;

public class SpecialtyPage extends BasePage {
    public SpecialtyPage(WebDriver driver) {
        super(driver);
    }

    public SpecialtyPage openPage() {
        goToUrl("/specialties", "Specialties");
        return this;
    }

    public List<Specialty> getSpecialtyList() {
        List<Specialty> specialty = new ArrayList<>();
        WebElement specialtyTable = driver.findElement(By.xpath("//*[@id='specialties']"));

        List<WebElement> specialtyList = specialtyTable.findElements(By.xpath("./tbody/tr"));
        for (WebElement specialtyRow : specialtyList) {
            specialty.add(createSpecialty(specialtyRow));
        }

        return specialty;
    }

    private Specialty createSpecialty(WebElement specialtiesRow) {
        Specialty specialty = new Specialty();

        specialty.setName(specialtiesRow.findElement(By.xpath(".//*[@name='spec_name']")).getAttribute("value"));

        return specialty;
    }

    public NewSpecialtyPage clickAddSpecialtyBtn() {
        WebElement addSpecialtyBtn = driver.findElement(By.xpath("//*[text()=' Add ']"));
        addSpecialtyBtn.click();
        return new NewSpecialtyPage(driver);
    }

}
