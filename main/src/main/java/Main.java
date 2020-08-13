import config.ValueAnnotationConfig;
import properties.AppProperties;

public class Main {
    public static void main(String[] args) {
        System.out.println("DZ_15\n----------------------------");

        AppProperties properties = new AppProperties();
        ValueAnnotationConfig configManager = new ValueAnnotationConfig();
        try {
            configManager.configure(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("name = " + properties.name);
        System.out.println("id = " + properties.id);
        System.out.println("status = " + properties.status);
    }
}
