package com.superdzen.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showStudentForm(Model model) {

        // create new Student object
        Student student = new Student();

        // ass Student object as a model attribute
        model.addAttribute("student", student);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("The student: "
                + student.getFirstName()
                + " " + student.getLastName());
        return "student-confirmation";
    }
}
