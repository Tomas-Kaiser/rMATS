package com.schoolproject.rmats.DAO;

import com.schoolproject.rmats.model.Customer;

public interface CustomerDAO {
    Customer getCustomerByEmail(String email);
}
