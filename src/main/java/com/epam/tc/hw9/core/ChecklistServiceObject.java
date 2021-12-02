package com.epam.tc.hw9.core;

import com.epam.tc.hw9.beans.Checklist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static com.epam.tc.hw9.util.PropertiesReader.getProperty;

public class ChecklistServiceObject extends BasicServiceObject {
    public static final URI CHECKLIST_URI = URI.create(getProperty("baseUri") + "/boards/{id}/checklists");

    public ChecklistServiceObject(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static Checklist getChecklistObject(Response response){
        return new Gson().fromJson(response.asString()
                .trim(), new TypeToken<List<Checklist>>() {}
                .getType());
    }
}
