package com.schoolproject.rmats.dao;

import com.schoolproject.rmats.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
    Customer findById(int customerId);
}
