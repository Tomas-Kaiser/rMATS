package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.CustomerRepository;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    public MyUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null)
            throw new UsernameNotFoundException("Customer not found");

        return new UserPrincipal(customer);
    }
}
