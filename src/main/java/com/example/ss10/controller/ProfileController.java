package com.example.ss10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.ss10.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class ProfileController {
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/bai4")
    public String showUploadForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String uploadAvatar(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        MultipartFile avatar = userProfile.getAvatar();
        try {
            Map uploadResult = cloudinary.uploader().upload(avatar.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL is null or empty");
            }
            model.addAttribute("url", url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userProfile", userProfile);
        return "result";
    }
}
