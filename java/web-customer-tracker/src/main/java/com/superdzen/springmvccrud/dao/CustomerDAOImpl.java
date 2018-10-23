package com.superdzen.springmvccrud.dao;

import com.superdzen.springmvccrud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery =
                session.createQuery(" from Customer order by lastName", Customer.class);

        // execute query
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        // get the current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        session.save(customer);

    }
}
