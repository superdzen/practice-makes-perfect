package com.superdzen.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showStudentForm(Model model) {

        // create new Student object
        Student student = new Student();

        // ass Student object as a model attribute
        model.addAttribute("student", student);

        model.addAttribute("theCountryOptions", countryOptions);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("The student: "
                + student.getFirstName()
                + " " + student.getLastName()
                + " " + student.getCountry());
        return "student-confirmation";
    }
}
