package com.epam.tc.hw9;

import static com.epam.tc.hw9.steps.BoardStep.createBoard;
import static com.epam.tc.hw9.steps.BoardStep.deleteBoard;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseApiTest {
    protected static String boardId;

    @BeforeClass
    public void setUp() {
        boardId = createBoard();
    }

    @AfterClass
    public void tearDown() {
        deleteBoard(boardId);
    }
}
