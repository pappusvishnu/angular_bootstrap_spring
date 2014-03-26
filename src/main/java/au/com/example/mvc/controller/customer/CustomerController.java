package au.com.example.mvc.controller.customer;

import au.com.example.mvc.model.customer.Customer;
import au.com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}
