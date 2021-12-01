package com.epam.tc.hw9.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class ListServiceObject extends BasicServiceObject {
    public ListServiceObject(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static List getListObject(Response response){
        return new Gson().fromJson(response.asString()
                .trim(), new TypeToken<List<List>>() {}
                .getType());
    }
}
