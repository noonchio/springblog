package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.reposotories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Controller
public class PostController {

    PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String post(Model vModel) {

        List<Post> posttList = postDao.findAll();

        // pass posts to view

        vModel.addAttribute("posts", posttList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = new Post(1,"HI", "Hello how you doin!");

        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")

    public String create() {
        return "posts/create";
    }

    @PostMapping( "/posts/create/{title}/{body}")

    public String newPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model vModel ) {
        Post post = new Post(title, body);
       postDao.save(post);
        return "redirect:/posts";
    }

//    @PostMapping( "/posts/create/{title}/{body}")
//
//    public String nPost(@PathVariable("title") String title, @PathVariable("body") String body, @RequestBody Post post) {
//       //setting data for post id
//        Post post1 = new Post(title, body);
//
//        // setting Post from title and body
//        postDao.save(post1);
//
//
//
////        postDao.save(post);
//        return "redirect:/posts";
//    }
}
