package com.counties.customers.dao;

import java.util.UUID;
import java.util.List;

import com.counties.customers.model.Customer;

abstract public class CustomerDAO {
    abstract public int createCustomer(UUID id, Customer customer);
    abstract public Customer getCustomer(UUID id);
    abstract public List<Customer> getAllCustomers();
    abstract public int updateCustomer(UUID id, Customer customer);
    abstract public int deleteCustomer(UUID id);

    public int createCustomer(Customer customer) {
        UUID id = UUID.randomUUID();
        return createCustomer(id, customer);
    }
}
