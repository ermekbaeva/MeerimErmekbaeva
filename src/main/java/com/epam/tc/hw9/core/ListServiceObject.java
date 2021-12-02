package com.epam.tc.hw9.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static com.epam.tc.hw9.util.PropertiesReader.getProperty;

public class ListServiceObject extends BasicServiceObject {
    public static final URI LIST_URI = URI.create(getProperty("baseUri") + "/boards/{id}/lists");

    public ListServiceObject(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static List getListObject(Response response){
        return new Gson().fromJson(response.asString()
                .trim(), new TypeToken<List<List>>() {}
                .getType());
    }
}
