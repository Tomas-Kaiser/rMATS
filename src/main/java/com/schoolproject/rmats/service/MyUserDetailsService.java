package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.AuthorizationRepository;
import com.schoolproject.rmats.dao.CustomerRepository;
import com.schoolproject.rmats.model.Authorization;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;
    private AuthorizationRepository authorizationRepository;

    public MyUserDetailsService(CustomerRepository customerRepository, AuthorizationRepository authorizationRepository) {
        this.customerRepository = customerRepository;
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        Authorization authorization = authorizationRepository.findByEmail(email);

        if (customer == null)
            throw new UsernameNotFoundException("Customer not found");

        if (authorization == null) {
            throw new UsernameNotFoundException("Authorization is not set up for the user");
        }

        return new UserPrincipal(customer, authorization);
    }
}
