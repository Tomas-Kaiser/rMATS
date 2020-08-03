package com.schoolproject.rmats.api;

import com.schoolproject.rmats.model.Customer;
import com.schoolproject.rmats.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class CustomerResourceTest {

    @InjectMocks
    CustomerResource customerResource;

    @Mock
    CustomerService customerService;

    Customer customer;

    final Integer customerId = 1;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customer = new Customer();
        customer.setId(customerId);
        customer.setFirstName("Tom");
        customer.setEmail("tom@c.cz");
    }

    @Test
    void getCustomerById() {
        Mockito.when(customerService.getCustomerById(Mockito.anyInt())).thenReturn(customer);

        Customer custRest = customerResource.getCustomerById(customerId);

        assertNotNull(custRest);
        assertEquals(customerId, custRest.getId());
        assertEquals(customer.getFirstName(), custRest.getFirstName());
        assertEquals(customer.getEmail(), custRest.getEmail());

    }
}