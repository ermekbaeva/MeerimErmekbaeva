package com.epam.tc.hw9.core;

import com.epam.tc.hw9.beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static com.epam.tc.hw9.constants.Constants.*;


public class BoardServiceObject extends BasicServiceObject {

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

    /*public static List<Board> getBoardId(Response response) {
        List<Board> boardId = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<Board>>() {
                }.getType());
        return boardId;
    }

    public static List<String> getStringResult(Response response) {
        return getBoardId(response).stream().map(Board::getName).collect(Collectors.toList());
    }*/

    public static class BoardRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

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
