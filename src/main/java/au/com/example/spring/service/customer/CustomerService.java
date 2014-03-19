package au.com.example.spring.service.customer;

import java.util.List;

import au.com.example.spring.mvc.model.customer.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
}
