package com.example.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String url;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;


    public PostImage(long id, String url, Post post) {
        this.id = id;
        this.url = url;
        this.post = post;
    }

    public PostImage() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
