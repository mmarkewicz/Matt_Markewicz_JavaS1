package com.company.commentservice.controller;

import com.company.commentservice.model.Comment;
import com.company.commentservice.service.CommentServiceLayer;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CacheConfig(cacheNames = {"comments"})
public class CommentController {

    @Autowired
    CommentServiceLayer service;

    @Cacheable
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return service.findAllComments();
    }

    @Cacheable
    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable int id) {
        return service.findCommentById(id);
    }

    @CachePut(key = "#results.getId()")
    @PostMapping("/comments")
    public Comment postComment(@RequestBody Comment comment) {
        return service.addComment(comment);
    }

    @CacheEvict(key = "#comments.getId()")
    @PutMapping("/comments")
    public void updateComment(@RequestBody Comment comment) throws Exception {
        service.updateComment(comment);
    }

    @CacheEvict
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable int id) {
        service.deleteComment(id);
    }
}
