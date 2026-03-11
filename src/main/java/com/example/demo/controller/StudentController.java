package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {

        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Student());

        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {

        service.saveStudent(student);

        return "redirect:/";
    }
}