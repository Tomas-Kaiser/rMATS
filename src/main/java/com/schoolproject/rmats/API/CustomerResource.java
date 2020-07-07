package com.schoolproject.rmats.API;
import com.schoolproject.rmats.Service.CustomerService;
import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerResource {

    CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path="/details")
    public Customer getCustomerByEmail(){
        return customerService.getCustomerByEmail();
    }
}
