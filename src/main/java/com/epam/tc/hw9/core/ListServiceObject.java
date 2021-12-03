package com.epam.tc.hw9.core;

import static com.epam.tc.hw9.constants.Constants.ID;
import static com.epam.tc.hw9.constants.Constants.NAME;
import static com.epam.tc.hw9.constants.Constants.POS;

import com.epam.tc.hw9.beans.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListServiceObject extends BasicServiceObject {

    public ListServiceObject(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static ListRequestBuilder listRequestBuilder() {
        return new ListRequestBuilder();
    }

    public static Lists getListObject(Response response){
        return new Gson().fromJson(response.asString()
                .trim(), new TypeToken<List<Lists>>() {}
                .getType());
    }

    public static class ListRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ListRequestBuilder setMethod (Method method){
            requestMethod = method;
            return this;
        }

        public ListRequestBuilder setId(String id) {
            parameters.put(ID, id);
            return this;
        }

        public ListRequestBuilder setName(String name) {
            parameters.put(NAME, name);
            return this;
        }

        public ListRequestBuilder setPos(String pos) {
            parameters.put(POS, pos);
            return this;
        }

        public ListServiceObject buildRequest() {
            return new ListServiceObject(parameters, requestMethod);
        }
    }
}
