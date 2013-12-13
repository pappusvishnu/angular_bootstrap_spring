package au.com.angular.js.mvc.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.angular.js.mvc.model.customer.Customer;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@RequestMapping(value = "/customers/retrieve", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer("Robert Leggett", "Robert", "Leggett"));
		customers.add(new Customer("Diana Lopez", "Diana", "Lopez"));
		customers.add(new Customer("Sara Leggett", "Sara", "Leggett"));
		customers.add(new Customer("Rafael Leggett", "Rafael", "Leggett"));
		
		return customers;
	}
}
