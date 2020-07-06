package com.schoolproject.rmats.Service;

import com.schoolproject.rmats.DAO.CustomerDAO;
import com.schoolproject.rmats.DAO.JdbcCustomerDAO;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomerService {

    JdbcCustomerDAO JdbcCustomerDAO = new JdbcCustomerDAO();

    public Customer getCustomerByEmail(){
        // To get an email from the login form
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return JdbcCustomerDAO.getCustomerByEmail(email);
    }
}
