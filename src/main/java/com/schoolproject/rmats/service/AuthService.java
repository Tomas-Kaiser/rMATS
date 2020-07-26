package com.schoolproject.rmats.service;

import com.schoolproject.rmats.api.rt.CustomerRT;
import com.schoolproject.rmats.dao.CustomerRepository;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final CustomerRepository customerRepository;

    @Autowired
    public AuthService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerRT getCustomerId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Customer currentCustomer = customerRepository.findByEmail(currentPrincipalName);

        CustomerRT customerRT = new CustomerRT();
        customerRT.setId(currentCustomer.getId());
        customerRT.setFirstName(currentCustomer.getFirstName());
        customerRT.setLastName(currentCustomer.getLastName());
        customerRT.setEmail(currentCustomer.getEmail());
        customerRT.setCompanyName(currentCustomer.getCompanyName());
        customerRT.setPhoneNumber(currentCustomer.getPhoneNumber());

        return customerRT;
    }
}
