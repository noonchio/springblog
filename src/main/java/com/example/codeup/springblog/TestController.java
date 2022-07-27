package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/firstview")
    public String returnHellowWorld(Model vModel) {
        vModel.addAttribute("name", "Alfredo");
        return "first-view";
    }

    @GetMapping("/favorite")
    public String returnFave() {
        return "favorite";
    }

    @PostMapping("/favorite")
    public String returnFaveResults(@RequestParam String location, Model vModel) {
        vModel.addAttribute("city", location);
        return "favorite-city";
    }
}
