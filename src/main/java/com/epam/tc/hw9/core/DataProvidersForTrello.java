package com.epam.tc.hw9.core;


import com.epam.tc.hw9.beans.Board;
import org.testng.annotations.DataProvider;

import static com.epam.tc.hw9.constants.Constants.TEST_NAME;

public class DataProvidersForTrello {
    @DataProvider
    public static Object[][] nameForBoardProvider() {
        Board board = new Board();
        board.setName(TEST_NAME);
        return new Object[][]{
                {board}
        };
    }

    @DataProvider
    public static Object[][] nameForListProvider() {
        Board board = new Board();
        board.setName(TEST_NAME);
        return new Object[][]{
                {board}
        };
    }
}
