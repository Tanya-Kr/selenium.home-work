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
        WebElement typesTable = driver.findElement(By.xpath("//*[@id='pettypes']"));

        List<WebElement> typesList = typesTable.findElements(By.xpath("./tbody/tr"));
        for (WebElement typesRow : typesList) {
            types.add(createPetTypes(typesRow));
        }

        return types;
    }

    private Type createPetTypes(WebElement typesRow) {
        Type type = new Type();

        type.setName(typesRow.findElement(By.xpath(".//*[@name='pettype_name']")).getAttribute("value"));

        return type;
    }

    public NewPetTypePage clickAddPetTypeBtn() {
        WebElement addVetBtn = driver.findElement(By.xpath("//*[text()=' Add ']"));
        addVetBtn.click();
        return new NewPetTypePage(driver);
    }

}
