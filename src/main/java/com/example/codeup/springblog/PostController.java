package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String post(Model vModel) {

        List<Post> posttList = new ArrayList<>(Arrays.asList(
                new Post("Ham", "helloooooooo"),
                new Post("Broom", "HIIIIIIII"),
                new Post("Broom", "helloo there")
        ));

        // pass posts to view

        vModel.addAttribute("posts", posttList);

        return "posts/index";
    }

//    @GetMapping("/posts/{number}")
//    @ResponseBody
//    public String postId(@PathVariable int number, Model model) {
//        Post post = new Post("HI", "Hello how you doin!");
//
//        model.addAttribute("post", post);
//        return "posts/show" + number;
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String create() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping( "/posts/create")
//    @ResponseBody
//    public String newPost( ) {
//        return "create a new post";
//    }
//}
}