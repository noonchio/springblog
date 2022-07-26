package com.example.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{number}/and/{number2}")
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2) {
        return number + number2 + "!";
    }

    @GetMapping("/subtract/{number}/from/{number2}")
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int number2) {
        int x = number - number2;
        return Math.abs(x);
    }

    @GetMapping("/multiply/{number}/and/{number2}")
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int number2) {
        return number * number2 + "!";
    }

    @GetMapping("/divide/{number}/by/{number2}")
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int number2) {
        return number / number2 + "!";
    }







}
