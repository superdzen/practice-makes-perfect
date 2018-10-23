package com.superdzen.springmvccrud.dao;

import com.superdzen.springmvccrud.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
