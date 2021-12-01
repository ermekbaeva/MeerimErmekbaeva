package com.epam.tc.hw9.core;

import com.epam.tc.hw9.beans.Checklist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class ChecklistServiceObject extends BasicServiceObject {
    public ChecklistServiceObject(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static Checklist getChecklistObject(Response response){
        return new Gson().fromJson(response.asString()
                .trim(), new TypeToken<List<Checklist>>() {}
                .getType());
    }
}
