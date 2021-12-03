package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.constants.Constants.NAME_FOR_BOARD;
import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.core.BasicServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class BoardStep {
    @Step
    public static String createBoard() {
        Response response = boardRequestBuilder()
                .setMethod(Method.POST)
                .setName(NAME_FOR_BOARD)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT);
        return getBoardObject(response).getId();
    }

    @Step
    public static String getBoardName(String id) {
        Response response = boardRequestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id);
        return getBoardObject(response).getName();
    }

    @Step
    public static void deleteBoard(String id) {
        boardRequestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + id)
                .then().assertThat()
                .spec(goodResponseSpecification());
    }
}
