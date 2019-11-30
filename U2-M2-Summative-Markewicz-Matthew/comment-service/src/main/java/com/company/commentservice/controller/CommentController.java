package com.company.commentservice.controller;

import com.company.commentservice.model.Comment;
import com.company.commentservice.service.CommentServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentServiceLayer service;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return service.findAllComments();
    }

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable int id) {
        return service.findCommentById(id);
    }

    @PostMapping("/comments")
    public Comment postComment(@RequestBody Comment comment) {
        return service.addComment(comment);
    }

    @PutMapping("/comments")
    public void updateComment(@RequestBody Comment comment) throws Exception {
        service.updateComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable int id) {
        service.deleteComment(id);
    }
}
