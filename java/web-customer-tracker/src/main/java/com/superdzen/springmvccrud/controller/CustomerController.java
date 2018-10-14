package com.superdzen.springmvccrud.controller;

import com.superdzen.springmvccrud.entity.Customer;
import com.superdzen.springmvccrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject the customer DAO
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model) {

        // get customer form the DAO
        List<Customer> customers = customerService.getCustomers();

        // add the list of customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
