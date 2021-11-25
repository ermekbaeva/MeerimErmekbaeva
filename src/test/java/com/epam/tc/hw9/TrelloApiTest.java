package com.epam.tc.hw9;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class TrelloApiTest {
    @Test
    public void checkBoardIsCreated() {
        given()
                .queryParams("key", "0e7e6abb6de81731e7c0cd1c595183ca")
                .queryParams("token", "0601ed1f1cd43bc665cc4efc71534f7b4283a82151c2e97c1b8448bbda1817a8")
                .baseUri("https://trello.com/")
                .log().all()
                .when()
                .post("/1/boards/")
                .then()
                .assertThat()
                .statusCode(200);
        ;
    }

    public void requestSpecificationTest() {
        RequestSpecification requestSpec = given()
                .baseUri("http://cookiemonster.com")
                .header("Language", "en");

        requestSpec.when()
                .get("/cookiesformonster")
                .then()
                .statusCode(200);

        requestSpec.when()
                .get("/soup")
                .then()
                .statusCode(400);
    }

    public void responseSpecificationTest() {
        ResponseSpecification responseSpec = expect()
                .statusCode(200);

        given()
                .expect()
                .spec(responseSpec)
                .when()
                .get("/hello");

        given()
                .expect()
                .spec(responseSpec)
                .when()
                .get("/goodbye");
    }
}
