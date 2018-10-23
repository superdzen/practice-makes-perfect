package com.superdzen.springmvccrud.service;

import com.superdzen.springmvccrud.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
