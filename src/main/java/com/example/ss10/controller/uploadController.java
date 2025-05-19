package com.example.ss10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.ss10.model.UploadFile;
import com.example.ss10.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class uploadController {
    @Autowired
    private UploadService uploadService;

    @Autowired
    private Cloudinary cloudinary;

    @RequestMapping("/bai6")
    public String showForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "uploadFormB6";
    }

    @PostMapping("/uploadB6")
    public String uploadFile(@ModelAttribute("uploadFile") UploadFile uploadFile, Model model) {
        MultipartFile file = uploadFile.getFile();
        String description = uploadFile.getDescription();
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL is null or empty");
            }

            boolean result = uploadService.upload(uploadFile);

            model.addAttribute("urlB6", url);
            model.addAttribute("description", description);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "result";
    }
}
