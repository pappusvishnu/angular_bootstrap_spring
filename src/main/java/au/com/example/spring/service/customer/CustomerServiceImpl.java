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

		customers.add(new Customer(1L, "Robert Leggett", "Robert", "Leggett"));
		customers.add(new Customer(2L, "Diana Lopez", "Diana", "Lopez"));
		customers.add(new Customer(3L, "Sara Leggett", "Sara", "Leggett"));
		customers.add(new Customer(4L, "Rafael Leggett", "Rafael", "Leggett"));

		return customers;
	}

    @Override
    public boolean deleteCustomer(Long id) {
        // TODO: once DB is established remove record from DB

        return true;
    }
}
