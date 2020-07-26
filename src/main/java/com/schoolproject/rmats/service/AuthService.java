package com.schoolproject.rmats.service;

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

    public String getCustomerId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        Customer currentCustomer = customerRepository.findByEmail(currentPrincipalName);
        System.out.println(currentCustomer.getId());
        return currentPrincipalName + " " + currentCustomer.getId();
    }
}
