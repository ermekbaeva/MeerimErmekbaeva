package com.epam.tc.hw9.steps;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.Random;
import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.core.BasicServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;

public class BoardStep {
    @Step
    public static String createBoard() {
        Faker faker = new Faker(new Random(24));
        Response response = requestBuilder()
                .setMethod(Method.POST)
                .setName(faker.name().firstName())
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT);
        return getBoardObject(response).getId();
    }

    @Step
    public static Response getBoard(String id) {
        return requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id);
    }

    @Step
    public static void deleteBoard(String id) {
        requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id)
                .then().assertThat()
                .spec(goodResponseSpecification());
    }
}
