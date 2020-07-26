package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.rt.CustomerRT;
import com.schoolproject.rmats.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthResource {

    private final AuthService authService;

    @Autowired
    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String home(){
        return ("<h1>Home</h1>");
    }

    @GetMapping("/admin/auth")
    public String adminAuthentication(){
        return ("<h1>Admin Auth</h1>");
    }

    @GetMapping("/customer/auth")
    @ResponseBody
    public CustomerRT customerAuthentication(){
        return authService.getCustomerId();
    }
}
