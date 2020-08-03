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
        // Get authentication object of the authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Get the current authenticated user name
        String currentPrincipalName = authentication.getName();
        // Get current customer object
        Customer currentCustomer = customerRepository.findByEmail(currentPrincipalName);
        // get auth object of currently authorized user
        Authorization auth = authorizationRepository.findByEmail(currentCustomer.getEmail());

        CustomerRT customerRT = convertToRTObject(currentCustomer);

        // Assign the status of isAdmin
        if (auth.getAuthority().equals("ROLE_CUSTOMER")){
            customerRT.setIsAdmin(false);
        } else {
            customerRT.setIsAdmin(true);
        }

        return customerRT;
    }

    private CustomerRT convertToRTObject(Customer currentCustomer){
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
