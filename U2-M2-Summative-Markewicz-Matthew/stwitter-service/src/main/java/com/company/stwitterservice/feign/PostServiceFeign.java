package com.company.stwitterservice.feign;

import com.company.stwitterservice.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceFeign {

    @GetMapping("/posts")
    List<Post> getAllPosts();

    @GetMapping("/post/id/{id}")
    Post getPostById(@PathVariable int id);

    @GetMapping("/post/name/{posterName}")
    List<Post> getPostsByPosterName(@PathVariable String posterName);

    @PostMapping("/posts")
    Post postPost(@RequestBody Post post);

    @PutMapping("/posts")
    void putPost(@RequestBody Post post);

    @DeleteMapping("/post/{id}")
    void deletePost(@PathVariable int id);
}
