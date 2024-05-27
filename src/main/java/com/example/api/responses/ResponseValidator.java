package com.example.api.responses;

import com.example.api.models.ResponseModel;
import com.example.api.InvalidResponseException;

public class ResponseValidator {

    public void validateResponse(ResponseModel response) {
        if (response == null) {
            throw new InvalidResponseException("Ответ не валиден: объект ResponseModel равен null.");
        }
        if (response.getStatusCode() < 200 || response.getStatusCode() >= 300) {
            throw new InvalidResponseException("Ответ не валиден: статус код " + response.getStatusCode() + " не соответствует успешному диапазону.");
        }
        System.out.println("Ответ валиден: статус код " + response.getStatusCode() + " в диапазоне успешных ответов.");
    }
}
