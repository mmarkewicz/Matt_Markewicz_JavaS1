package com.company.postservice.repository;

import com.company.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostServiceRepository extends JpaRepository <Post, Integer> {
    List<Post> findPostsByPosterName(String posterName);
}
