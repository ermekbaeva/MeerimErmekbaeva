package com.epam.tc.hw9;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.core.DataProvidersForTrello;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.tc.hw9.core.BoardServiceObject.*;
import static com.epam.tc.hw9.steps.BoardStep.createBoard;
import static com.epam.tc.hw9.steps.BoardStep.deleteAllBoards;
import static com.epam.tc.hw9.util.PropertiesReader.getProperty;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseApiTest {

/*    @BeforeTest
    public void setUp() {
        given(requestSpec)
                .queryParam(KEY,getProperty("key"))
                .queryParam(TOKEN,getProperty("token"))
                .when()
                .get("/");
    }*/

    @Test(dataProvider = "nameForBoardProvider", dataProviderClass = DataProvidersForTrello.class)
    public void checkBoardIsCreated(Board board) {
        createBoard(board);
    }

    @AfterTest
    public void tearDown() {
        deleteAllBoards();
    }
}
