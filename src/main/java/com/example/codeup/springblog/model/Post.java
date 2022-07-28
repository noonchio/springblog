package com.example.codeup.springblog.model;

import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String body;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Post() {

    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
