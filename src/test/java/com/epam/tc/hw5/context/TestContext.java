package com.epam.tc.hw5.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static TestContext instance;

    private Map<String, Object> context = new HashMap<>();

    private TestContext(){
    }

    public <T> T getObject(String key) {
        return (T) context.get(key);
    }

    public <T> T getObject(String key, Class<T> objectClass) {
        return objectClass.cast(context.get(key));
    }

    public void addObject(String key, Object object) {
        context.put(key, object);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
