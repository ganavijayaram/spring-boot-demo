package com.springboot.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// make java class as controller
//
// convert response from Java to JSON
//@ResponseBody
@RestController //= @ResponseBody + @Controller
public class HelloWorldController {

    //HTTP GET Request
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Ganavi Got a coop!";
    }
}
