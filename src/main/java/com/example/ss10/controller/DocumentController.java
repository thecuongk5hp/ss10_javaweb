package com.example.ss10.controller;

import com.example.ss10.model.Document;
import com.example.ss10.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("bai5")
    public String showForm(Model model) {
        model.addAttribute("document", new Document());
        return "documentForm";
    }

    @PostMapping("/uploadB5")
    public String uploadDocument(@ModelAttribute Document document, RedirectAttributes redirectAttributes) {
        boolean success = documentService.createDocument(document);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Upload thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Upload thất bại!");
        }

        return "redirect:/bai5";
    }

}
