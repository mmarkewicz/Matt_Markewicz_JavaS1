package com.company.stwitterservice.feign;

import com.company.stwitterservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceFeign {

    @GetMapping("/comments")
    List<Comment> getAllComments();

    @GetMapping("/comment/{id}")
    Comment getCommentById(@PathVariable int id);

    @PostMapping("/comments")
    Comment postComment(@RequestBody Comment comment);

    @PutMapping("/comments")
    void putComment(@RequestBody Comment comment);

    @DeleteMapping("/comment/{id}")
    void deleteComment(@PathVariable int id);
}
