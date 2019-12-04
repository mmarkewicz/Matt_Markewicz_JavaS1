package com.company.stwitterservice.controller;

import com.company.stwitterservice.model.Post;
import com.company.stwitterservice.model.PostViewModel;
import com.company.stwitterservice.service.StwitterServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CacheConfig(cacheNames = {"posts"})
public class StwitterController {

    @Autowired
    StwitterServiceLayer service;

    @Cacheable
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable int id) throws Exception {
        return service.getPost(id);
    }

    @Cacheable
    @GetMapping("/posts/user/{posterName}")
    public List<Post> getPostsByUser(@PathVariable String posterName) throws Exception {
        return service.getPostsByPoster(posterName);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody @Valid PostViewModel postViewModel) throws Exception {
        return service.createPost(postViewModel);
    }
}