package com.example.codeup.springblog.reposotories;

import com.example.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
