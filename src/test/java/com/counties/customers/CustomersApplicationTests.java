package com.counties.customers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.counties.customers.api.CustomerController;
import com.counties.customers.model.Customer;
import com.counties.customers.model.Surname;

@SpringBootTest
class CustomersApplicationTests {

	@Autowired CustomerController customerController;

	@Test void findBySurname() {
		//given
		Surname surname = new Surname("Bingham");
		List<Customer> sampleData = customerController.getAllCustomers();
		List<Customer> expected = Arrays.asList(sampleData.get(0), //Ryan Bingham
												sampleData.get(4), //Kara Bingham
												sampleData.get(5) //Julie Bingham
												);

		//when
		List<Customer> customers = customerController.getCustomersBySurname(surname);

		//then
		assertTrue(customers.size() == expected.size() && customers.containsAll(expected) && expected.containsAll(customers));
	}

}
