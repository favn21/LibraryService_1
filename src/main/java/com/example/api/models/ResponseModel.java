package com.example.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel {
    private int authorId;
    private String message;
    private int statusCode;

    public ResponseModel(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}