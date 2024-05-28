package com.example.api.models;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private Long authorId;
}
