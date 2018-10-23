package com.superdzen.springmvccrud.controller;

import com.superdzen.springmvccrud.entity.Customer;
import com.superdzen.springmvccrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save the customer using our service

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

}
