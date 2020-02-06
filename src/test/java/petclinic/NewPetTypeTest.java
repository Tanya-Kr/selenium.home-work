package petclinic;


import org.testng.annotations.Test;
import petclinic.Page.object.NewPetTypePage;
import petclinic.Page.object.PetTypesPage;
import petclinic.model.Type;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewPetTypeTest extends TestBase {

    @Test
    public void addNewPetTypeTest() {
        PetTypesPage petTypesPage = new PetTypesPage(driver);
        petTypesPage.openPage();

        NewPetTypePage newPetTypePage = petTypesPage.clickAddPetTypeBtn();

        newPetTypePage.fillType(fillTypeObject());

        petTypesPage = newPetTypePage.waitClickSavePetTypeBtn();

        List<Type> petTypes = petTypesPage.getPetTypesList();
        assertThat(petTypes).contains(fillTypeObject());

    }

    @Test
    public void sendEmptyPetTypeFieldTest() {
        PetTypesPage petTypesPage = new PetTypesPage(driver);
        petTypesPage.openPage();
        List<Type> petTypes = petTypesPage.getPetTypesList();
        int petTypeCounter = petTypes.size();

        NewPetTypePage newPetTypePage = petTypesPage.clickAddPetTypeBtn();

        petTypesPage = newPetTypePage.clickSavePetTypeBtn();
        petTypes = petTypesPage.getPetTypesList();

        assertThat(petTypeCounter).isEqualTo(petTypes.size());

    }

    private Type fillTypeObject() {
        Type type = new Type();
        type.setName("Owl");
        return type;
    }

}
