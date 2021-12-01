package com.epam.tc.hw9.steps;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.core.BoardServiceObject;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static com.epam.tc.hw9.core.BasicServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;

public class BoardStep {
    @Step
    public static String createBoard(Board board) {
        Response response = requestBuilder()
                .setMethod(Method.POST)
                .setName(board.getName())
                .buildRequest()
                .sendRequest();
        response.then()
                .assertThat()
                .spec(goodResponseSpecification());
        return getBoardObject(response).getId();
    }

    @Step
    public void getBoard() {

    }

    @Step
    public static void deleteAllBoards() {

    }
}
