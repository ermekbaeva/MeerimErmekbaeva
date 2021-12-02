package com.epam.tc.hw9.steps;

import com.epam.tc.hw9.beans.Board;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Random;

import static com.epam.tc.hw9.constants.EndPoints.CHECKLISTS_ENDPOINT;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;

public class ChecklistStep {
    @Step
    public static String createChecklist() {
        Faker faker = new Faker(new Random(24));
        Response response =  requestBuilder()
                .setMethod(Method.POST)
                .setName(faker.name().firstName())
                .buildRequest()
                .sendRequest(CHECKLISTS_ENDPOINT);
        return getBoardObject(response).getId();
    }

    @Step
    public static Board getChecklist(String id) {
        Response response =  requestBuilder()
                .setMethod(Method.GET)
                .setId(id)
                .buildRequest()
                .sendRequest(CHECKLISTS_ENDPOINT);
        return getBoardObject(response);
    }
}
