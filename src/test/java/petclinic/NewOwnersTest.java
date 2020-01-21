package petclinic;

import petclinic.model.Owner;
import petclinic.Page.object.NewOwnerPage;
import petclinic.Page.object.OwnersPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewOwnersTest extends TestBase {

    @Test
    public void addNewOwnerTest() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        Owner owner = new Owner();
        owner.setFirstName("Mark");
        owner.setLastName("Jones");
        owner.setAddress("Brok");
        owner.setCity("New York");
        owner.setTelephone("987654321");

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        ownersPage = newOwnerPage.clickAddOwnerButton();

        List<Owner> ownersNames = ownersPage.getOwnersList();
        assertThat(ownersNames).contains(owner);
    }
}
