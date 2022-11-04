package com.counties.customers.api;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.counties.customers.model.Customer;
import com.counties.customers.model.Surname;
import com.counties.customers.service.CustomerService;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void createCustomer(@Validated @RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomer(@PathVariable("id") UUID id) {
        return customerService.getCustomer(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping
    public List<Customer> getCustomersBySurname(@Validated @RequestBody Surname surname) {
        return customerService.getCustomersBySurname(surname.get());
    }

    @PutMapping(path = "{id}")
    public int updateCustomer(@PathVariable("id") UUID id, @Validated @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping(path = "{id}")
    public int deleteCustomer(@PathVariable("id") UUID id) {
        return customerService.deleteCustomer(id);
    }
}
