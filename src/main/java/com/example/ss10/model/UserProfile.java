package com.example.ss10.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfile {
    private MultipartFile avatar;
    private String username;
}
