package com.epam.tc.hw9;

import org.testng.annotations.Test;

import static com.epam.tc.hw9.steps.BoardStep.getBoard;

public class BoardApiTest extends BaseApiTest {
    @Test
    public void checkBoardIsCreated() {
        getBoard(boardId)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
