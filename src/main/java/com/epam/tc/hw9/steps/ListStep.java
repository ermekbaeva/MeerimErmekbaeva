package com.epam.tc.hw9.steps;

import com.epam.tc.hw9.beans.Board;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Random;

import static com.epam.tc.hw9.constants.EndPoints.LISTS_ENDPOINT;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;

public class ListStep {
    @Step
    public static String createList() {
        Faker faker = new Faker(new Random(24));
        Response response =  requestBuilder()
                .setMethod(Method.POST)
                .setName(faker.name().firstName())
                .buildRequest()
                .sendRequest(LISTS_ENDPOINT);
        return getBoardObject(response).getId();
    }

    @Step
    public static Board getList(String id) {
        Response response =  requestBuilder()
                .setMethod(Method.GET)
                .setId(id)
                .buildRequest()
                .sendRequest(LISTS_ENDPOINT);
        return getBoardObject(response);
    }
}
