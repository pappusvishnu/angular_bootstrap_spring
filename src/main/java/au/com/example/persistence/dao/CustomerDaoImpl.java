package au.com.example.persistence.dao;

import au.com.example.mvc.model.customer.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<Customer>();
    }

    @Transactional
    @Override
    public boolean deleteCustomer(Long id) {
        return false;
    }


}
