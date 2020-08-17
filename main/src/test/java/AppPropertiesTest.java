import config.ValueAnnotationConfig;
import org.junit.Test;
import properties.AppProperties;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

public class AppPropertiesTest {
    AppProperties properties = new AppProperties();
    ValueAnnotationConfig configManager = new ValueAnnotationConfig();

    String nameExpectedValue = "Alina";
    Integer idExpectedValue = 6;
    Boolean statusExpectedValue = true;

    @Test
    public void configureTestName() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        configManager.configure(properties);
        assertTrue(properties.name.equals(nameExpectedValue));


    }

    @Test
    public void configureTestId() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        configManager.configure(properties);
        assertTrue(properties.id.equals(idExpectedValue));
    }

    @Test
    public void configureTestStatus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        configManager.configure(properties);
        assertTrue(properties.status.equals(statusExpectedValue));
    }

}
