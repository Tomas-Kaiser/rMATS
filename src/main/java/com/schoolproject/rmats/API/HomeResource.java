package com.schoolproject.rmats.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return ("<h1>Home</h1>");
    }

    @GetMapping("/customers")
    public String customers(){
        return ("<h1>This is for customers!</h1>");
    }

    @GetMapping("/customers/1")
    public String customer(){
        return ("<h1>Customer 1!</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>This is for admin!</h1>");
    }
}
