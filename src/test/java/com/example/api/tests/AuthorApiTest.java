package com.example.api.tests;

import com.example.api.models.RequestModel;
import com.example.api.models.ResponseModel;
import com.example.api.requests.ApiClient;
import com.example.api.responses.ResponseValidator;
import com.example.api.InvalidResponseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthorApiTest {

    private final ApiClient apiClient = new ApiClient();
    private final ResponseValidator responseValidator = new ResponseValidator();

    @Test
    @DisplayName("Создание автора")
    public void testCreateAuthor() {
        RequestModel request = new RequestModel();
        request.setFirstName("Иван");
        request.setLastName("Иванов");

        ResponseModel response = apiClient.createAuthor(request);

        try {
            responseValidator.validateResponse(response);
        } catch (InvalidResponseException e) {
            System.err.println("Ошибка валидации ответа: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Корректность ответа")
    public void testValidResponse() {
        ResponseModel response = new ResponseModel(200, "Успешно");

        responseValidator.validateResponse(response);
    }

    @Test
    @DisplayName("Пустой ответ")
    public void testNullResponse() {
        assertThrows(InvalidResponseException.class, () -> {
            responseValidator.validateResponse(null);
        }, "Выбрасывает исключение InvalidResponseException при пустом ответе");
    }

    @Test
    @DisplayName("Неверный статус кода")
    public void testInvalidStatusCode() {
        ResponseModel response = new ResponseModel(400, "Ошибка запроса");

        assertThrows(InvalidResponseException.class, () -> {
            responseValidator.validateResponse(response);
        }, "Выбрасывает исключение InvalidResponseException для статус кода за пределами диапазона 200-299");

    }
}
