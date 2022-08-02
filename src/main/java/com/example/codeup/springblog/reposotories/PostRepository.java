package com.example.codeup.springblog.reposotories;

import com.example.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long>{
// all we need to have access to jpa
//    1.basic of entities: JapRepository (built-in methods)
//    2.Derivied Queries: write a custom name method and Hibernate creates it for you
//    3.@Query annotation: you can use JPQL to define more specific queries
//     also you can create a query using MySQL syntax
}
