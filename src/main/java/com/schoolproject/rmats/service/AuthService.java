package com.schoolproject.rmats.service;

import com.schoolproject.rmats.api.rt.CustomerRT;
import com.schoolproject.rmats.dao.AuthorizationRepository;
import com.schoolproject.rmats.dao.CustomerRepository;
import com.schoolproject.rmats.model.Authorization;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthService {
    private final CustomerRepository customerRepository;
    private final AuthorizationRepository authorizationRepository;

    @Autowired
    public AuthService(CustomerRepository customerRepository, AuthorizationRepository authorizationRepository) {
        this.customerRepository = customerRepository;
        this.authorizationRepository = authorizationRepository;
    }

    public CustomerRT getCustomer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Customer currentCustomer = customerRepository.findByEmail(currentPrincipalName);
        Authorization auth = authorizationRepository.findByEmail(currentCustomer.getEmail());

        CustomerRT customerRT = new CustomerRT();
        customerRT.setId(currentCustomer.getId());
        customerRT.setFirstName(currentCustomer.getFirstName());
        customerRT.setLastName(currentCustomer.getLastName());
        customerRT.setEmail(currentCustomer.getEmail());
        customerRT.setCompanyName(currentCustomer.getCompanyName());
        customerRT.setPhoneNumber(currentCustomer.getPhoneNumber());

        if (auth.getAuthority().equals("ROLE_CUSTOMER")){
            customerRT.setIsAdmin(false);
        } else {
            customerRT.setIsAdmin(true);
        }

        return customerRT;
    }
}
