package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.Constants.INCORRECT_NAME;
import static com.epam.tc.hw9.constants.Constants.NAME_FOR_BOARD;
import static com.epam.tc.hw9.steps.BoardStep.getBoardName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;


public class BoardApiTest extends BaseApiTest {

    @Test
    public void checkNameIsCorrect() {
        String name = getBoardName(boardId);
        assertThat(name, equalToIgnoringCase(NAME_FOR_BOARD));
    }

    @Test
    public void checkIncorrectName() {
        String name = getBoardName(boardId);
        assertThat(name, not(equalToIgnoringCase(INCORRECT_NAME)));
    }
}
