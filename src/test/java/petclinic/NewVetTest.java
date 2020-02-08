package petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import petclinic.Page.object.NewVeterinarianPage;
import petclinic.Page.object.VeterinariansPage;
import petclinic.model.Vet;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class NewVetTest extends TestBase {

    private By firstNameErrorMessage = By.cssSelector("#firstName~.help-block");
    private By lastNameErrorMessage = By.cssSelector("#lastName~.help-block");


    @Test
    public void addNewVetTest(){
        VeterinariansPage veterinariansPage = new VeterinariansPage(driver);
        veterinariansPage.openPage();

        NewVeterinarianPage newVeterinarianPage = veterinariansPage.clickAddVetBtn();

        Vet vet = new Vet();
        vet.setFirstName("Tom");
        vet.setLastName("Jerry");
        vet.setSpecialty(chooseSpecialty());

        newVeterinarianPage.fillVet(vet);

        veterinariansPage = newVeterinarianPage.clickAddVetButton();

        List<Vet> vetsNames = veterinariansPage.getVetsList();
        assertThat(vetsNames).contains(vet);

    }

    @Test
    public void checkErrorMessageVetTest(){
        VeterinariansPage veterinariansPage = new VeterinariansPage(driver);
        veterinariansPage.openPage();

        NewVeterinarianPage newVeterinarianPage = veterinariansPage.clickAddVetBtn();

        newVeterinarianPage.setFirstName("T");
        newVeterinarianPage.setLastName("J");

        WebElement firstNameErrorMessageText = driver.findElement(firstNameErrorMessage);
        WebElement lastNameErrorMessageText = driver.findElement(lastNameErrorMessage);

        assertThat(firstNameErrorMessageText.getText()).isEqualTo("First name must be at least 2 characters long");
        assertThat(lastNameErrorMessageText.getText()).isEqualTo("Last name must be at least 2 characters long");

        newVeterinarianPage.clearFirstName();
        newVeterinarianPage.clearLastName();

        firstNameErrorMessageText = driver.findElement(firstNameErrorMessage);
        lastNameErrorMessageText = driver.findElement(lastNameErrorMessage);

        assertThat(firstNameErrorMessageText.getText()).isEqualTo("First name is required");
        assertThat(lastNameErrorMessageText.getText()).isEqualTo("Last name is required");

    }

    private String chooseSpecialty() {
        List<WebElement> specialtyList = driver.findElements(By.cssSelector("#specialties option"));
        Random rand = new Random();
        String specialty = specialtyList.get(rand.nextInt(specialtyList.size())).getText();
        System.out.println(specialty);
        return specialty.trim();
    }
}
