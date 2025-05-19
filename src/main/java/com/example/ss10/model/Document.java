package com.example.ss10.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Document {
    private String title;
    private String description;
    private MultipartFile file;
}
