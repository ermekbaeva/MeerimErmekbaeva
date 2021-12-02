package com.epam.tc.hw9.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.net.URI;
import java.util.Map;

import static com.epam.tc.hw9.constants.Constants.KEY;
import static com.epam.tc.hw9.constants.Constants.TOKEN;
import static com.epam.tc.hw9.util.PropertiesReader.getProperty;
import static org.hamcrest.Matchers.lessThan;

public class BasicServiceObject {
    public static final URI BOARD_URI = URI.create(getProperty("baseUri"));
    protected Method requestMethod;
    protected Map<String, String> parameters;

    public BasicServiceObject(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public Response sendRequest(String endpoint) {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParam(KEY,getProperty("key"))
                .queryParam(TOKEN,getProperty("token"))
                .queryParams(parameters)
                .request(requestMethod, BOARD_URI + endpoint)
                .prettyPeek();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri(BOARD_URI)
                .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(10000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification badResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(lessThan(10000L))
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }
}
