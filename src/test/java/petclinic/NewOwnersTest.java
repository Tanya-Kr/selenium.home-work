package petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(fillOwnerObject());
        ownersPage = newOwnerPage.clickAddOwnerButton();

        List<Owner> ownersNames = ownersPage.getOwnersList();
        assertThat(ownersNames).contains(fillOwnerObject());
    }

    @Test
    public void checkErrorMessages() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        Owner owner = new Owner();
        owner.setFirstName("M");
        owner.setLastName("J");
        owner.setAddress("Brok");
        owner.setCity("New York");
        owner.setTelephone("qqq");

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);

        WebElement firstNameErrorMessage = driver.findElement(By.cssSelector("#firstName~.help-block"));
        WebElement lastNameErrorMessage = driver.findElement(By.cssSelector("#lastName~.help-block"));
        WebElement telephoneErrorMessage = driver.findElement(By.cssSelector("#telephone~.help-block"));

        assertThat(firstNameErrorMessage.getText()).isEqualTo("First name must be at least 2 characters long");
        assertThat(lastNameErrorMessage.getText()).isEqualTo("Last name must be at least 2 characters long");
        assertThat(telephoneErrorMessage.getText()).isEqualTo("Phone number only accept digits");
    }

    @Test
    public void checkErrorMessage() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(fillOwnerObject());

        newOwnerPage.clearFirstName();
        newOwnerPage.clearLastName();
        newOwnerPage.clearAddress();
        newOwnerPage.clearCity();
        newOwnerPage.clearTelephone();

        WebElement firstNameErrorMessage = driver.findElement(By.cssSelector("#firstName~.help-block"));
        WebElement lastNameErrorMessage = driver.findElement(By.cssSelector("#lastName~.help-block"));
        WebElement addressErrorMessage = driver.findElement(By.cssSelector("#address~.help-block"));
        WebElement cityErrorMessage = driver.findElement(By.cssSelector("#city~.help-block"));
        WebElement telephoneErrorMessage = driver.findElement(By.cssSelector("#telephone~.help-block"));

        assertThat(firstNameErrorMessage.getText()).isEqualTo("First name is required");
        assertThat(lastNameErrorMessage.getText()).isEqualTo("Last name is required");
        assertThat(addressErrorMessage.getText()).isEqualTo("Address is required");
        assertThat(cityErrorMessage.getText()).isEqualTo("City is required");
        assertThat(telephoneErrorMessage.getText()).isEqualTo("Phone number is required");
    }

    private Owner fillOwnerObject() {
        Owner owner = new Owner();
        owner.setFirstName("Mark");
        owner.setLastName("Jones");
        owner.setAddress("Brok");
        owner.setCity("New York");
        owner.setTelephone("987654321");
        return owner;
    }
}
