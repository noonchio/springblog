package com.example.codeup.springblog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

   @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images = new ArrayList<>();


    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

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

    public void findByTitle(String title){
        this.title = title;
    }


}
