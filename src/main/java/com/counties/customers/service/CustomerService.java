package com.counties.customers.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.counties.customers.dao.CustomerDAO;
import com.counties.customers.model.Customer;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService (@Qualifier("inMemory") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public int createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    };

    public Customer getCustomer(UUID id) {
        return customerDAO.getCustomer(id);
    };

    public List<Customer> getCustomersBySurname(String surname) {
        List<Customer> customers = getAllCustomers();
        customers.removeIf(c -> !c.getSurname().equalsIgnoreCase(surname));
        return customers;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    };

    public int updateCustomer(UUID id, Customer customer) {
        return customerDAO.updateCustomer(id, customer);
    };

    public int deleteCustomer(UUID id) {
        return customerDAO.deleteCustomer(id);
    };
}
