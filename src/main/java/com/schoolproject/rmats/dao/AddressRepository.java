package com.schoolproject.rmats.dao;

import com.schoolproject.rmats.model.Address;
import com.schoolproject.rmats.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUserId(int userId);
}
