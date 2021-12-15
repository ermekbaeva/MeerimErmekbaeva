package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.constants.EndPoints.LISTS_ENDPOINT;
import static com.epam.tc.hw9.core.ListServiceObject.listRequestBuilder;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class ListStep {
    @Step
    public static Response createList(String boardId, String listName) {
        return listRequestBuilder()
                .setMethod(Method.POST)
                .setName(listName)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + boardId + LISTS_ENDPOINT);
    }

    @Step
    public static Response getLists(String boardId) {
        return listRequestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + boardId + LISTS_ENDPOINT);
    }
}
