package petclinic;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import petclinic.Page.object.OwnerInformationPage;
import petclinic.Page.object.OwnersPage;
import petclinic.model.Owner;
import petclinic.model.Pet;

import java.util.List;

public class NewPetTest {

    private PetClinicNavigation navigation;

//    @BeforeMethod
//    public void setUpBeforeClass() {
//        navigation = new PetClinicNavigation();
//    }

    @Test
    public void addNewPetTest(){
        OwnersPage ownersPage = navigation.openOwnerPage();
        OwnerInformationPage ownerInformationPage = ownersPage.openOwnerInfo("Eduardo Rodriquez");

        Owner ownerInfo = ownerInformationPage.getOwnerInfo();
        System.out.println(ownerInfo);

        List<Pet> pets = ownerInformationPage.getPets();
    }
}
