package petclinic;

import petclinic.configuration.Configuration;
import org.openqa.selenium.WebDriver;
import petclinic.Page.object.NewOwnerPage;
import petclinic.Page.object.OwnersPage;

public class PetClinicNavigation {
    private WebDriver driver;
    private petclinic.configuration.Configuration configuration = petclinic.configuration.Configuration.getInstance();

    public PetClinicNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public NewOwnerPage openNewOwnerPage() {
        driver.get(configuration.baseUrl() + "/owners/add");
        return new NewOwnerPage(driver);
    }

    public OwnersPage openOwnerPage() {
        driver.get(configuration.baseUrl() + "/owners");
        return new OwnersPage(driver);
    }
}
