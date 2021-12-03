package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.constants.Constants.NAME_FOR_LIST;
import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.constants.EndPoints.LISTS_ENDPOINT;
import static com.epam.tc.hw9.core.ListServiceObject.listRequestBuilder;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class ListStep {
    @Step
    public static Response createList(String id) {
        Response response = listRequestBuilder()
                .setMethod(Method.POST)
                .setName(NAME_FOR_LIST)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id + LISTS_ENDPOINT);
        return response;
    }

    @Step
    public static Response getList(String id) {
        Response response = listRequestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id + LISTS_ENDPOINT);
        return response;
    }
}
