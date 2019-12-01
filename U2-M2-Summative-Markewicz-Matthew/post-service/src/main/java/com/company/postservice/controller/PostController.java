package com.company.postservice.controller;

import com.company.postservice.model.Post;
import com.company.postservice.service.PostServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostServiceLayer service;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/post/id/{id}")
    public Post getPostById(@PathVariable int id) {
        return service.getPostById(id);
    }

    @GetMapping("/post/name/{posterName}")
    public List<Post> getPostsByPosterName(@PathVariable String posterName) {
        return service.getPostsByPoster(posterName);
    }

    @PostMapping("/posts")
    public Post postPost(@RequestBody Post post) {
        return  service.postPost(post);
    }

    @PutMapping("/posts")
    public void putPost(@RequestBody Post post) {
        service.updatePost(post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable int id) {
        service.deletePost(id);
    }

}
