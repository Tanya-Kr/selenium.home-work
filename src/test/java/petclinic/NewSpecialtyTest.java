package petclinic;


import org.testng.annotations.Test;
import petclinic.Page.object.NewSpecialtyPage;
import petclinic.Page.object.SpecialtyPage;
import petclinic.TestBase;
import petclinic.model.Specialty;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewSpecialtyTest extends TestBase {

    @Test
    public void addSpecialtyTest() {
        SpecialtyPage specialtyPage = new SpecialtyPage(driver);
        specialtyPage.openPage();

        NewSpecialtyPage newSpecialtyPage = specialtyPage.clickAddSpecialtyBtn();

        newSpecialtyPage.fillSpecialty(fillSpecialtyObject());

        specialtyPage = newSpecialtyPage.waitClickSaveSpecialtyBtn();

        List<Specialty> specialty = specialtyPage.getSpecialtyList();
        assertThat(specialty).contains(fillSpecialtyObject());

    }

    @Test
    public void sendEmptySpecialtyFieldTest() {
        SpecialtyPage specialtyPage = new SpecialtyPage(driver);
        specialtyPage.openPage();
        List<Specialty> specialty = specialtyPage.getSpecialtyList();
        int specialtyCounter = specialty.size();

        NewSpecialtyPage newSpecialtyPage = specialtyPage.clickAddSpecialtyBtn();

        specialtyPage = newSpecialtyPage.clickSaveSpecialtyBtn();
        specialty = specialtyPage.getSpecialtyList();

        assertThat(specialtyCounter).isEqualTo(specialty.size());

    }

    private Specialty fillSpecialtyObject() {
        Specialty specialty = new Specialty();
        specialty.setName("Surgeon");
        return specialty;
    }

}
