package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.reposotories.PostRepository;
import com.example.codeup.springblog.reposotories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Controller
public class PostController {
//    Use dependency injection to use an instance of this new Posts interface

 private   PostRepository postDao;

 private   UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
      Post p = postDao.findById(id).get();

        model.addAttribute("p", p);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create() {
        return "posts/create";
    }

//    @PostMapping( "/posts/create")
//    public String newPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model vModel) {
//        Post post = new Post(title, body);
//       postDao.save(post);
////       save works as update and create
//        return "redirect:/posts";
//    }
//    delete a record with JPA
    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping( "/posts/create")
    public String newPostandUser(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model vModel) {
        User user = userDao.findById(1L).get();
        Post post = new Post(title, body);
        post.setUser(user);
        postDao.save(post);

//       save works as update and create
        return "redirect:/posts";
    }
}
