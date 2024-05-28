package com.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GetBooksByAuthorResponse {
    private List<Book> books;

    @Data
    public static class Book {
        private int id;
        private String title;
        private int authorId;
    }
}