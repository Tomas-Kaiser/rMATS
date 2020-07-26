package com.schoolproject.rmats.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@CrossOrigin
@RestController
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return ("<h1>Home</h1>");
    }
}
