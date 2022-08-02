package com.example.codeup.springblog.reposotories;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
