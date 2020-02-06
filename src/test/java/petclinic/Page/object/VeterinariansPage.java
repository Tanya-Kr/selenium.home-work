package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petclinic.model.Vet;

import java.util.ArrayList;
import java.util.List;

public class VeterinariansPage extends BasePage {

    public VeterinariansPage(WebDriver driver) {
        super(driver);
    }

    public VeterinariansPage openPage() {
        goToUrl("/vets", "Veterinarians");
        return this;
    }

    public List<Vet> getVetsList() {
        List<Vet> vets = new ArrayList<>();
        WebElement vetsTable = driver.findElement(By.id("vets"));

        List<WebElement> vetsList = vetsTable.findElements(By.xpath(".//tbody/tr"));
        for (WebElement vetsRow : vetsList) {
            vets.add(createVet(vetsRow));
        }

        return vets;
    }

    private Vet createVet(WebElement vetsRow) {
        Vet vet = new Vet();
        String fullName = vetsRow.findElement(By.xpath("./td[1]")).getText();
        String[] fullNameArray = fullName.split(" ");
        if (fullNameArray.length > 1) {
            vet.setFirstName(fullNameArray[0]);
            vet.setLastName(fullNameArray[1]);
        } else {
            vet.setFirstName(fullNameArray[0]);
        }

        String specialty = vetsRow.findElement(By.xpath("./td[2]")).getText();
        if(!specialty.isEmpty()) {
            vet.setSpecialty(specialty);
        } else {
            vet.setSpecialty(null);
        }

        return vet;
    }

    public NewVeterinarianPage clickAddVetBtn() {
        WebElement addVetBtn = driver.findElement(By.xpath("//*[text()='Add Vet']"));
        addVetBtn.click();
        return new NewVeterinarianPage(driver);
    }
}
