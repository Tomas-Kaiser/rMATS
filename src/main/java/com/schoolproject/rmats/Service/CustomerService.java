package com.schoolproject.rmats.Service;

import com.schoolproject.rmats.DAO.CustomerDAO;
import com.schoolproject.rmats.DAO.JdbcCustomerDAO;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer getCustomerByEmail(){
        // To get an email from the login form
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return customerDAO.getCustomerByEmail(email);
    }
}
