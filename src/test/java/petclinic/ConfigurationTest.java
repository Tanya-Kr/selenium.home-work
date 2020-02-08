package petclinic;

import petclinic.configuration.Configuration;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {

    @Test
    public void urlTest() {
        String baseUrl = Configuration.getInstance().baseUrl();
        System.out.println("baseUrl: " +  baseUrl);
        assertThat(baseUrl).isNotBlank();

        baseUrl = Configuration.getInstance().baseUrl();
        System.out.println("baseUrl: " +  baseUrl);
        assertThat(baseUrl).isNotBlank();
    }
}
