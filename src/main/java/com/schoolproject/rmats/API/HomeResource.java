package com.schoolproject.rmats.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>This is for admin!</h1>");
    }
}
