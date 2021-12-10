package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.steps.BoardStep.createBoard;
import static com.epam.tc.hw9.steps.BoardStep.deleteBoardById;
import static com.epam.tc.hw9.steps.BoardStep.getBoard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Method;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


public class BoardApiTest extends BaseApiTest {

    @Test
    public void checkBoardHasCorrectName() {
        String randomStringForBoardName = RandomStringUtils.random(10, true, false);
        board = createBoard(randomStringForBoardName);
        String boardName = getBoardObject(
                getBoard(board.getId())
                        .then()
                        .extract()
                        .response()).getName();
        assertThat(boardName, equalTo(randomStringForBoardName));
    }

    @Test
    public void boardDeleteById() {
        String randomStringForBoardName = RandomStringUtils.random(10, true, false);
        board = createBoard(randomStringForBoardName);
        deleteBoardById(board.getId());
        getBoard(board.getId())
                .then()
                .statusCode(404);
    }

    @Test
    public void boardUpdateClosedStatus() {
        String randomStringForBoardName = RandomStringUtils.random(10, true, false);
        board = createBoard(randomStringForBoardName);
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
        String randomStringForBoardName = RandomStringUtils.random(10, true, false);
        board = createBoard(randomStringForBoardName);
        board = getBoardObject(boardRequestBuilder()
                .setMethod(Method.PUT)
                .setName(randomStringForBoardName)
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT + board.getId())
                .then()
                .extract().response());
        assertThat(board.getName(), equalTo(randomStringForBoardName));
    }

}
