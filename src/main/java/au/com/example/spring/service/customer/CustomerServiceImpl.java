package au.com.example.spring.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.example.spring.mvc.model.customer.Customer;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> getCustomers() {
		
		// TODO: get the results from a dao (in-memory) for less viewer setup required
		
		List<Customer> customers = new ArrayList<Customer>();

		customers.add(new Customer("Robert Leggett", "Robert", "Leggett"));
		customers.add(new Customer("Diana Lopez", "Diana", "Lopez"));
		customers.add(new Customer("Sara Leggett", "Sara", "Leggett"));
		customers.add(new Customer("Rafael Leggett", "Rafael", "Leggett"));

		return customers;
	}
}
