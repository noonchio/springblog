package com.example.codeup.springblog.reposotories;

import com.example.codeup.springblog.model.Post;

import com.example.codeup.springblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
