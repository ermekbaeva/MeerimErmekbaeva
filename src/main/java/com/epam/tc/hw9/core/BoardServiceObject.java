package com.epam.tc.hw9.core;

import com.epam.tc.hw9.beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.epam.tc.hw9.constants.Constants.*;
import static com.epam.tc.hw9.util.PropertiesReader.getProperty;


public class BoardServiceObject extends BasicServiceObject{
    public BoardServiceObject(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static BoardRequestBuilder requestBuilder() {
        return new BoardRequestBuilder();
    }

    public static Board getBoardObject(Response response){
        return new Gson().fromJson(response.asString()
                .trim(), new TypeToken<Board>() {}
                .getType());
    }

    public static List<Board> getBoardId(Response response) {
        List<Board> boardId = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<Board>>() {
                }.getType());
        return boardId;
    }

    public static List<String> getStringResult(Response response) {
        return getBoardId(response).stream().map(board -> board.getName()).collect(Collectors.toList());
    }

    public static class BoardRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.POST;

        public BoardRequestBuilder setMethod (Method method){
            requestMethod = method;
            return this;
        }

        public BoardRequestBuilder setId(String id) {
            parameters.put(ID, id);
            return this;
        }

        public BoardRequestBuilder setName(String name) {
            parameters.put(NAME, name);
            return this;
        }

        public BoardRequestBuilder setDesc(String desc) {
            parameters.put(DESC, desc);
            return this;
        }

        public BoardRequestBuilder setDescData(String descData) {
            parameters.put(DESC_DATA, descData);
            return this;
        }

        public BoardRequestBuilder setClosed(String closed) {
            parameters.put(CLOSED, closed);
            return this;
        }

        public BoardRequestBuilder setIdOrganization(String idOrganization) {
            parameters.put(ID_ORGANIZATION, idOrganization);
            return this;
        }

        public BoardServiceObject buildRequest() {
            return new BoardServiceObject(parameters, requestMethod);
        }
    }
}
