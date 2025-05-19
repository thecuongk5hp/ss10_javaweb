package com.example.ss10.controller;

import com.example.ss10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("bai2")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("addProduct")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        return "result";
    }
}
