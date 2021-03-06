package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.EndPoints.BOARDS_ENDPOINT;
import static com.epam.tc.hw9.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw9.core.ListServiceObject.getListObject;
import static com.epam.tc.hw9.steps.BoardStep.createBoard;
import static com.epam.tc.hw9.steps.ListStep.createList;
import static com.epam.tc.hw9.steps.ListStep.getLists;
import static com.epam.tc.hw9.util.RandomString.randomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.Method;
import java.util.ArrayList;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class ListApiTest extends BaseApiTest {
    @Test
    public void checkListHasCorrectName() {
        String randomStr = randomString();
        board = createBoard();
        list = getListObject(createList(board.getId(), randomStr));
        assertThat(list.getName(), equalTo(randomStr));
    }

    //By default board is created with 3 default lists on it. You can turn off this option
    @Test
    public void createBoardWithNoLists() {
        board = getBoardObject(boardRequestBuilder()
                .setMethod(Method.POST)
                .setName(randomString())
                .setDefaultLists("false")
                .buildRequest()
                .sendRequest(BOARDS_ENDPOINT)
                .then()
                .extract().response());
        ArrayList<String> lists = getLists(board.getId()).jsonPath().get();
        assertThat(lists, Matchers.empty());
    }
}
