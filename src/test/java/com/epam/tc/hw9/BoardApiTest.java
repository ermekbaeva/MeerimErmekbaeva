package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.Constants.NAME_FOR_BOARD;
import static com.epam.tc.hw9.constants.Constants.INCORRECT_NAME;
import static com.epam.tc.hw9.steps.BoardStep.getBoard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;


public class BoardApiTest extends BaseApiTest {
    @Test
    public void checkBoardIsCreated() {
        getBoard(boardId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body().jsonPath()
                .prettyPrint();
    }

    @Test
    public void checkNameIsCorrect() {
        String name = getBoard(boardId).jsonPath().getString("name");
        assertThat(name, equalToIgnoringCase(NAME_FOR_BOARD));
    }

    @Test
    public void checkIncorrectName() {
        String name = getBoard(boardId).jsonPath().getString("name");
        assertThat(name, not(equalToIgnoringCase(INCORRECT_NAME)));
    }
}
