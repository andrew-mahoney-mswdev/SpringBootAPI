package com.counties.customers.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Repository;

import com.counties.customers.model.Customer;

@Repository("inMemory")
public class InMemoryCustomerDAO extends CustomerDAO {

    private static List<Customer> customers = new ArrayList<>();

    static { //Sample data
        customers.add(new Customer(UUID.randomUUID(), "Ryan", "Bingham", "ryan.bingham@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Alex", "Goran", "alex.goram@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Natalie", "Keener", "natalie.keener@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Craig", "Gregory", "craig.gregory@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Kara", "Bingham", "kara.bingham@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Julie", "Bingham", "julie.bingham@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Maynard", "Finch", "maynard.finch@upintheair.com"));
        customers.add(new Customer(UUID.randomUUID(), "Jim", "Miller", "jim.miller@upintheair.com"));
    }

    @Override
    public int createCustomer(UUID id, Customer customer) {
        customers.add(new Customer(id, customer.getName(), customer.getSurname(), customer.getEmail()));
        return 0;
    }

    @Override
    public Customer getCustomer(UUID id) {
        final AtomicReference<Customer> atomicCustomer = new AtomicReference<>(null);
        customers.forEach(c -> {
            if (c.getId().equals(id))
                atomicCustomer.set(c);
        });
        return atomicCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public int updateCustomer(UUID id, Customer customer) {
        Customer customerOrNull = getCustomer(id);
        if (customerOrNull != null) {
            deleteCustomer(id);
            createCustomer(id, customer);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int deleteCustomer(UUID id) {
        Customer customerOrNull = getCustomer(id);
        if (customerOrNull != null) {
            customers.remove(customerOrNull);
            return 1;
        } else {
            return 0;
        }
    }
 
}
