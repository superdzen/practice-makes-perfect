package com.superdzen.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("processForm")
    public String processForm() {
        return "helloworld";
    }

    // new controller method to read from data and
    // add data to the model
    @RequestMapping("/processFormVTwo")
    public String processFormVersionTwo(HttpServletRequest request, Model model) {

        String formParam = request.getParameter("studentName");

        model.addAttribute("msg", formParam.toUpperCase());

        return "helloworld";
    }

    @RequestMapping("/processFormVThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String name,
            Model model) {
        model.addAttribute("msg", name.toUpperCase());
        return "helloworld";
    }
}
