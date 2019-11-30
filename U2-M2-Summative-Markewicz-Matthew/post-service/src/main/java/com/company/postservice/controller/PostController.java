package com.company.postservice.controller;

import com.company.postservice.model.Post;
import com.company.postservice.service.PostServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CacheConfig(cacheNames = {"posts"})
public class PostController {

    @Autowired
    PostServiceLayer service;

    @Cacheable
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @Cacheable
    @GetMapping("/post/id/{id}")
    public Post getPostById(@PathVariable int id) {
        return service.getPostById(id);
    }

    @Cacheable
    @GetMapping("/post/name/{posterName}")
    public List<Post> getPostsByPosterName(@PathVariable String posterName) {
        return service.getPostsByPoster(posterName);
    }

    @CachePut(key = "#results.getId()")
    @PostMapping("/posts")
    public Post postPost(@RequestBody Post post) {
        return  service.postPost(post);
    }

    @CacheEvict(key = "#posts.getId()")
    @PutMapping("/posts")
    public void putPost(@RequestBody Post post) {
        service.updatePost(post);
    }

    @CacheEvict
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable int id) {
        service.deletePost(id);
    }

}
