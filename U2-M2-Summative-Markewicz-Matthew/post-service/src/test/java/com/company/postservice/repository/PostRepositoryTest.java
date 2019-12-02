package com.company.postservice.repository;

import com.company.postservice.model.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PostRepositoryTest {

    @Autowired
    PostServiceRepository repository;

    @Before
    public void setUp() {
        List<Post> postList = repository.findAll();
        postList.forEach(post -> repository.deleteById(post.getPostID()));
    }

    @After
    public void tearDown() {
        List<Post> postList = repository.findAll();
        postList.forEach(post -> repository.deleteById(post.getPostID()));
    }

    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        post = repository.save(post);

        assertEquals(post.toString(), repository.getOne(post.getPostID()).toString());
        repository.deleteById(post.getPostID());
        assertEquals(0, repository.findAll().size());
    }

    @Test
    public void shouldGetAllPosts() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        repository.save(post);

        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void shouldUpdatePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        post = repository.save(post);

        post.setPost("New Test Post");
        post = repository.save(post);

        assertEquals("New Test Post", repository.getOne(post.getPostID()).getPost());
    }

    @Test
    public void shouldReturnPostsByPosterName() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        repository.save(post);

        List<Post> postList = repository.findPostsByPosterName("Test Poster Name");
        List<Post> invalidPostList = repository.findPostsByPosterName("None");

        assertEquals(postList.size(), 1);
        assertEquals(invalidPostList.size(), 0);
    }
}
