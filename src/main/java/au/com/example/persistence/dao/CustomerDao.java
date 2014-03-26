package au.com.example.persistence.dao;

import au.com.example.mvc.model.customer.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();

    boolean deleteCustomer(Long id);
}
