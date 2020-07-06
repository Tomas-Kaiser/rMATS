package com.schoolproject.rmats.API;

import com.schoolproject.rmats.Service.CustomerService;
import com.schoolproject.rmats.model.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerResource {

    CustomerService customerService = new CustomerService();

    @GetMapping(path = "/details")
    public Customer getCustomer(){
        return customerService.getCustomerByEmail();
    }
}
