package com.schoolproject.rmats.service;

import com.schoolproject.rmats.model.Authorization;
import com.schoolproject.rmats.model.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private Customer customer;
    private Authorization authorization;

    public UserPrincipal(Customer customer, Authorization authorization) {
        this.customer = customer;
        this.authorization = authorization;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String auth = authorization.getAuthority();
        List<GrantedAuthority> authList;
        authList = Arrays.stream(authorization.getAuthority().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return authList;
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    public String getEmail(){
        return customer.getEmail();
    }

    @Override
    public String getUsername() {
        return customer.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
