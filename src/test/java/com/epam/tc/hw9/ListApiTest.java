package com.epam.tc.hw9;

import static com.epam.tc.hw9.constants.Constants.NAME_FOR_LIST;
import static com.epam.tc.hw9.constants.Constants.INCORRECT_NAME;
import static com.epam.tc.hw9.steps.ListStep.createList;
import static com.epam.tc.hw9.steps.ListStep.getList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

import java.util.List;
import org.testng.annotations.Test;


public class ListApiTest extends BaseApiTest {
    @Test
    public void checkListIsCreated() {
        createList(boardId)
                .then()
                .assertThat()
                .statusCode(200);
        List<String> name = getList(boardId).jsonPath().getList("name");
        assertThat(name, hasItem(NAME_FOR_LIST));
    }

    @Test
    public void checkNameIsCorrect() {
        String name = getList(boardId).jsonPath().getString("name");
        assertThat(name, not(equalToIgnoringCase(INCORRECT_NAME)));
    }
}
