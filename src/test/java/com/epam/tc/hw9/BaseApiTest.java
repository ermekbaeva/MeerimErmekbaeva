package com.epam.tc.hw9;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static com.epam.tc.hw9.steps.BoardStep.*;

public class BaseApiTest {
    protected static String boardId;

    @BeforeTest
    public void setUp() {
        boardId = createBoard();
    }

    @AfterTest
    public void tearDown() {
        deleteBoard(boardId);
    }
}
