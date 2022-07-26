package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
// Establishes that this class is a controller.
@Controller
public class HelloController {
// Establishes the URL Pattern we are listening for (specifically a Get request)
    @GetMapping("/hello")
    @ResponseBody
// Defines what the response body will be.
    public String hello() {
        return "Hello from Spring";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/increment/{number}")
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number + " plus one = " +(number + 1) + "!";
    }
}
