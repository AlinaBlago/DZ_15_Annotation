package config;

import annotation.PropertyKey;
import util.ResourceUtil;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class ValueAnnotationConfig {
    private  Map<Object, Object> map;

    public ValueAnnotationConfig() {
        map = ResourceUtil. getResource("application.properties");

    }

    public  void configure(Object o) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> implClass = o.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            PropertyKey annotation = field.getAnnotation(PropertyKey.class);
            if (annotation != null) {
                Object value ;
                if(!annotation.value().isEmpty()){
                    value = field.getType().getConstructor(String.class).newInstance(map.get(annotation.value()));
                }else{
                    value = annotation.value();
                }
                field.setAccessible(true);
                try {
                    field.set(o, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Возникли проблемы с инициализацией филда: " + e.getMessage());
                }
            }
        }
    }

}
