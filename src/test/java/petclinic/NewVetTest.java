package petclinic;

import org.testng.annotations.Test;
import petclinic.Page.object.NewVeterinarianPage;
import petclinic.Page.object.VeterinariansPage;
import petclinic.model.Vet;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewVetTest extends TestBase {

    @Test
    public void addNewVetTest(){
        VeterinariansPage veterinariansPage = new VeterinariansPage(driver);
        veterinariansPage.openPage();

        NewVeterinarianPage newVeterinarianPage = veterinariansPage.clickAddVetBtn();

        newVeterinarianPage.fillVet(fillVetObject());

        veterinariansPage = newVeterinarianPage.clickAddVetButton();

        List<Vet> vetsNames = veterinariansPage.getVetsList();
        assertThat(vetsNames).contains(fillVetObject());

    }

    public Vet fillVetObject() {
        Vet vet = new Vet();
        vet.setFirstName("Tom");
        vet.setLastName("Jerry");

        return vet;
    }

}
