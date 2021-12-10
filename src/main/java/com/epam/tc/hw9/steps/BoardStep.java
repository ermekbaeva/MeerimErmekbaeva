package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.constants.EndPoints.MEMBER_ENDPOINT;
import static com.epam.tc.hw9.core.BasicServiceObject.goodResponseSpecification;
import static com.epam.tc.hw9.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.util.PropertiesReader.getProperty;

import com.epam.tc.hw9.beans.TrelloBoard;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.List;


public class BoardStep {
    @Step
    public static TrelloBoard createBoard(String boardName) {
        Response response = boardRequestBuilder()
                .setMethod(Method.POST)
                .setName(boardName)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT)
                .then().extract().response();
        return getBoardObject(response);
    }

    @Step
    public static Response getBoard(String boardId) {
        return boardRequestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + boardId)
                .then()
                .extract().response();
    }

    @Step
    public static void deleteBoardById(String boardId) {
        boardRequestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + boardId);
    }

    @Step
    public static void deleteAllBoards() {
        for (String boardId : getAllIdBoards()
        ) {
            deleteBoardById(boardId);
        }
    }

    @Step
    public static List<String> getAllIdBoards() {
        return boardRequestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(MEMBER_ENDPOINT + getProperty("userId") + BOARDS_ENDPOINT)
                .then().assertThat()
                .spec(goodResponseSpecification())
                .extract().response().jsonPath().getList("id");
    }

}
