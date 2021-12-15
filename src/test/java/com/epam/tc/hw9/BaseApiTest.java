package com.epam.tc.hw9;

import static com.epam.tc.hw9.steps.BoardStep.deleteAllBoards;

import com.epam.tc.hw9.beans.TrelloBoard;
import com.epam.tc.hw9.beans.TrelloList;
import org.testng.annotations.AfterMethod;


public class BaseApiTest {
    TrelloBoard board;
    TrelloList list;

    @AfterMethod
    public void tearDown() {
        deleteAllBoards();
    }
}
