package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.PostImage;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.reposotories.PostImageRepository;
import com.example.codeup.springblog.reposotories.PostRepository;
import com.example.codeup.springblog.reposotories.UserRepository;
//import com.example.codeup.springblog.services.EmailService;
import com.example.codeup.springblog.services.Example;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Controller
public class PostController {
//    Use dependency injection to use an instance of this new Posts interface

 private   PostRepository postDao;

 private   UserRepository userDao;

 private PostImageRepository postImageDao;
// private final EmailService emailService;
 private final Example email;

    public PostController(PostRepository postDao, UserRepository userDao, PostImageRepository postImageDao, Example email) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postImageDao = postImageDao;
        this.email = email;
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
    public String create(Model model) {;
        model.addAttribute("newPost", new Post());
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
    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();
        postDao.delete(post);
        return "redirect:/posts";
    }

    @PostMapping( "/posts/create")
    public String newPostAndUser(@ModelAttribute Post newPost) throws IOException {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setUser(principal);
        postDao.save(newPost);
//        email.prepareAndSendReal(post); this one sends the email

        return "redirect:/posts";
    }

    @GetMapping("/posts/cats")
    public String postImage(Model vModel) {
        List<PostImage> posttList = postImageDao.findAll();
        // pass posts to view
        vModel.addAttribute("posts", posttList);
        return "posts/showcats";
    }

    @GetMapping("/posts/{id}/edit")
    public String showUpdateForm(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();

        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
//         postDao.findById(id).get();
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts" ;
    }







}
