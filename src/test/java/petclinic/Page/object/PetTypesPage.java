package petclinic.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petclinic.model.Type;

import java.util.ArrayList;
import java.util.List;

public class PetTypesPage extends BasePage {
    public PetTypesPage(WebDriver driver) {
        super(driver);
    }

    public PetTypesPage openPage() {
        goToUrl("/pettypes", "Pet Types");
        return this;
    }

    public List<Type> getPetTypesList() {
        List<Type> types = new ArrayList<>();
        WebElement typesTable = driver.findElement(By.id("pettypes"));

        List<WebElement> typesList = typesTable.findElements(By.xpath(".//tbody/tr"));
        for (WebElement userRow : typesList) {
            types.add(createPetTypes(userRow));
        }

        return types;
    }
    //*[@id='pettypes']/tbody/tr/td[1]
    private Type createPetTypes(WebElement userRow) {
        Type type = new Type();
        String typeName = userRow.findElement(By.xpath("./td[1]//*[@name='pettype_name']")).getText();
        type.setName(typeName);

        return type;
    }

    public NewPetTypePage clickAddPetTypeBtn() {
        WebElement addVetBtn = driver.findElement(By.xpath("//*[text()=' Add ']"));
        addVetBtn.click();
        return new NewPetTypePage(driver);
    }

}
