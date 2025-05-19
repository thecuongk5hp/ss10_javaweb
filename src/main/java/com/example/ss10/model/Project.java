package com.example.ss10.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    private String name;
    private String description;
    private List<Document> documents;
}
