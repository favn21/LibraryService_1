package com.example.api.requests;

import com.example.api.models.RequestModel;
import com.example.api.models.ResponseModel;
import okhttp3.*;

import java.io.IOException;

public class ApiClient {

    private final OkHttpClient client = new OkHttpClient();

    public ResponseModel createAuthor(RequestModel request) {
        if (request == null || request.getFirstName() == null || request.getLastName() == null) {
            return new ResponseModel(1001, "Invalid request data");
        }

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String jsonBody = "{\"firstName\": \"" + request.getFirstName() + "\", \"lastName\": \"" + request.getLastName() + "\"}";

        Request httpRequest = new Request.Builder()
                .url("http://api.example.com/authors")
                .post(RequestBody.create(jsonBody, JSON))
                .build();

        try (Response httpResponse = client.newCall(httpRequest).execute()) {
            if (httpResponse.isSuccessful()) {
                return new ResponseModel(httpResponse.code(), "Author created successfully");
            } else {
                return new ResponseModel(httpResponse.code(), "Error creating author");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseModel(500, "Internal server error");
        }
    }
}
