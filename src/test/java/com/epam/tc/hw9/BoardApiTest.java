package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.core.BasicServiceObject.badResponseSpecification;
import static com.epam.tc.hw9.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.steps.BoardStep.createBoard;
import static com.epam.tc.hw9.steps.BoardStep.deleteBoardById;
import static com.epam.tc.hw9.steps.BoardStep.getBoard;
import static com.epam.tc.hw9.util.RandomString.randomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.Method;
import org.testng.annotations.Test;


public class BoardApiTest extends BaseApiTest {

    @Test
    public void boardDeleteById() {
        board = createBoard();
        deleteBoardById(board.getId());
        getBoard(board.getId())
                .then().assertThat()
                .spec(badResponseSpecification());
    }

    @Test
    public void boardUpdateClosedStatus() {
        board = createBoard();
        board = getBoardObject(boardRequestBuilder()
                .setMethod(Method.PUT)
                .setClosed("true")
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + board.getId())
                .then()
                .extract().response());
        assertThat(board.getClosed(), equalTo("true"));
    }

    @Test
    public void boardUpdateName() {
        String randomStr = randomString();
        board = createBoard();
        board = getBoardObject(boardRequestBuilder()
                .setMethod(Method.PUT)
                .setName(randomStr)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + board.getId())
                .then()
                .extract().response());
        assertThat(board.getName(), equalTo(randomStr));
    }

}
