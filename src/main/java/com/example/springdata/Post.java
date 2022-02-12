package com.example.springdata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> commmets = new HashSet<>();

    public void addComment(Comment comment) {
        this.getCommmets().add(comment);
        comment.setPost(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getCommmets() {
        return commmets;
    }

    public void setCommmets(Set<Comment> commmets) {
        this.commmets = commmets;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                '}';
    }
}
