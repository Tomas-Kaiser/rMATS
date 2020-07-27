package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.rt.CustomerRT;
import com.schoolproject.rmats.service.AuthService;
import com.schoolproject.rmats.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class AuthResource {
    public static final Logger log = LogManager.getLogger(AuthResource.class);
    private final AuthService authService;


    @Autowired
    public AuthResource(AuthService authService, CustomerService customerService) {
        this.authService = authService;
    }

    @GetMapping("/admin/auth")
    public String adminAuthentication(){
        return ("<h1>Admin Auth</h1>");
    }

    @GetMapping("/customer/auth")
    @ResponseBody
    public CustomerRT customerAuthentication(){
        return authService.getCustomer();
    }
}
