package au.com.example.spring.mvc.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.example.spring.mvc.model.customer.Customer;
import au.com.example.spring.service.customer.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/customers/retrieve", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
}
