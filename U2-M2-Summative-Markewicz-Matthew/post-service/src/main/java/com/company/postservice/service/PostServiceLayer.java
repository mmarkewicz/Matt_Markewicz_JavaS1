package com.company.postservice.service;

import com.company.postservice.model.Post;
import com.company.postservice.repository.PostServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceLayer {

    @Autowired
    PostServiceRepository repository;

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post getPostById(int id) {
        return repository.getOne(id);
    }

    public List<Post> getPostsByPoster(String posterName) {
        return repository.findPostsByPosterName(posterName);
    }

    public Post postPost(Post post) {
        return repository.save(post);
    }

    public void updatePost(Post post) {
        repository.save(post);
    }

    public void deletePost(int id) {
        repository.deleteById(id);
    }
}
