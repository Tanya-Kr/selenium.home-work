package petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import petclinic.Page.object.NewPetTypePage;
import petclinic.Page.object.PetTypesPage;
import petclinic.model.Type;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class NewPetTypeTest extends TestBase {

    @Test
    public void addNewPetTypeTest() {
        PetTypesPage petTypesPage = new PetTypesPage(driver);
        petTypesPage.openPage();
//
        NewPetTypePage newPetTypePage = petTypesPage.clickAddPetTypeBtn();

        Type type = new Type();
        type.setName("Frog");
        newPetTypePage.setPetType(type.getName());

        petTypesPage = newPetTypePage.clickSavePetTypeButton();

        List<Type> petTypes = petTypesPage.getPetTypesList();


        WebElement petTypeFieldq = driver.findElement(By.xpath(".//tbody/tr[1]/td[1]/input"));
        String d = petTypeFieldq.getText();
        System.out.println(d);

        assertThat(petTypes).contains(type);

    }


}
