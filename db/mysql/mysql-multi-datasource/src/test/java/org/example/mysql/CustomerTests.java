package org.example.mysql;

import org.example.mysql.customer.data.CustomerModel;
import org.example.mysql.customer.repo.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional("customerTransactionManager")
    public void create_check_customer() {

        CustomerModel customer = new CustomerModel("user@www.javadevjournal.com", "Robert", "Hickle");
        customer = customerRepository.save(customer);

        assertNotNull(customerRepository.findById(customer.getId()));
        assertEquals(customerRepository.findById(customer.getId()).get().getEmail(), "user@www.javadevjournal.com");
    }
}
