package com.example.ss10.controller;

import com.example.ss10.model.Project;
import com.example.ss10.model.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    private List<Project> projectList = new ArrayList<>();

    @GetMapping("/bai7")
    public String showFormProject(Model model) {
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute Project project,
                                @RequestParam("files") List<MultipartFile> files,
                                Model model) {
        List<Document> documents = new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    Document doc = new Document();
                    doc.setTitle(file.getOriginalFilename());
                    doc.setDescription("Mô tả tài liệu");
                    doc.setFile(file);
                    documents.add(doc);
                }
            }
        }
        project.setDocuments(documents);
        projectList.add(project);

        model.addAttribute("project", project);
        return "redirect:/listProjects";
    }

    @GetMapping("/listProjects")
    public String listProjects(Model model) {
        model.addAttribute("projects", projectList);
        return "projectList";
    }

    @GetMapping("/editProject")
    public String editProject(@RequestParam String name, Model model) {
        for (Project project : projectList) {
            if (project.getName().equals(name)) {
                model.addAttribute("project", project);
                return "projectForm";
            }
        }
        model.addAttribute("message", "Không tìm thấy dự án");
        return "redirect:/listProjects";
    }

    @PostMapping("/updateProject")
    public String updateProject(@ModelAttribute Project updatedProject, Model model) {
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getName().equals(updatedProject.getName())) {
                projectList.set(i, updatedProject);
                model.addAttribute("project", updatedProject);
                model.addAttribute("message", "Project updated successfully");
                return "redirect:/listProjects";
            }
        }
        model.addAttribute("message", "Không tìm thấy dự án để cập nhật");
        return "redirect:/listProjects";
    }

    @GetMapping("/deleteProject")
    public String deleteProject(@RequestParam String name, Model model) {
        projectList.removeIf(project -> project.getName().equals(name));
        model.addAttribute("message", "Project deleted successfully");
        return "redirect:/listProjects";
    }
}
