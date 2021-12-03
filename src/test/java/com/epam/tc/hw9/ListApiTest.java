package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.Constants.INCORRECT_NAME;
import static com.epam.tc.hw9.constants.Constants.NAME;
import static com.epam.tc.hw9.constants.Constants.NAME_FOR_LIST;
import static com.epam.tc.hw9.steps.ListStep.getLists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

import java.util.List;
import org.testng.annotations.Test;


public class ListApiTest extends BaseApiTest {
    @Test
    public void checkListCorrectName() {
        List<String> name = getLists(boardId).jsonPath().getList(NAME);
        assertThat(name, hasItem(NAME_FOR_LIST));
    }

    @Test
    public void checkIncorrectName() {
        List<String> name = getLists(boardId).jsonPath().getList(NAME);
        assertThat(name, not(hasItem(INCORRECT_NAME)));
    }
}
