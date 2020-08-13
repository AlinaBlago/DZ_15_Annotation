package properties;

import annotation.PropertyKey;

public class AppProperties {
    @PropertyKey("id")
    public Integer id;

    @PropertyKey("name")
    public String name;

    @PropertyKey("status")
    public Boolean status;
}
