package com.company.postservice.service;

import com.company.postservice.model.Post;
import com.company.postservice.repository.PostServiceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PostServiceLayerTest {

    PostServiceLayer service;

    @Mock
    PostServiceRepository repository;

    @Before
    public void setUp() {
        setUpMocks();
        service = new PostServiceLayer(repository);
    }

    @Test
    public void shouldReturnPostAfterAdding() {
        Post postFromDb = new Post();
        postFromDb.setPostID(5);
        postFromDb.setPost("Test Post");
        postFromDb.setPosterName("Test Poster");
        postFromDb.setPostDate(LocalDate.of(2019, 1, 1));

        Post post = new Post();
        post.setPosterName("Test Poster");
        post.setPost("Test Post");
        post.setPostDate(LocalDate.of(2019, 1, 1));

        assertEquals(service.postPost(post).toString(), postFromDb.toString());
    }

    @Test
    public void shouldReturnPostFromFindById() {
        Post postFromDb = new Post();
        postFromDb.setPostID(5);
        postFromDb.setPost("Test Post");
        postFromDb.setPosterName("Test Poster");
        postFromDb.setPostDate(LocalDate.of(2019, 1, 1));

        assertEquals(service.getPostById(5).toString(), postFromDb.toString());
    }

    @Test
    public void shouldReturnListOfPostsFromFindAllPosts() {
        Post postFromDb = new Post();
        postFromDb.setPostID(5);
        postFromDb.setPost("Test Post");
        postFromDb.setPosterName("Test Poster");
        postFromDb.setPostDate(LocalDate.of(2019, 1, 1));

        List<Post> postList = new ArrayList<>();
        postList.add(postFromDb);

        assertEquals(service.getAllPosts().get(0).toString(), postFromDb.toString());
    }

    @Test
    public void shouldReturnListOfPostsByPosterName() {
        Post postFromDb = new Post();
        postFromDb.setPostID(5);
        postFromDb.setPost("Test Post");
        postFromDb.setPosterName("Test Poster");
        postFromDb.setPostDate(LocalDate.of(2019, 1, 1));

        List<Post> postList = new ArrayList<>();
        postList.add(postFromDb);

        assertEquals(postList.toString(), service.getPostsByPoster("Test Poster").toString());
    }

    public void setUpMocks() {
        Post postFromDb = new Post();
        postFromDb.setPostID(5);
        postFromDb.setPost("Test Post");
        postFromDb.setPosterName("Test Poster");
        postFromDb.setPostDate(LocalDate.of(2019, 1, 1));

        Post post = new Post();
        post.setPosterName("Test Poster");
        post.setPost("Test Post");
        post.setPostDate(LocalDate.of(2019, 1, 1));

        List<Post> postList = new ArrayList<>();
        postList.add(postFromDb);

        doReturn(postFromDb).when(repository).getOne(5);
        doReturn(postList).when(repository).findAll();
        doReturn(postFromDb).when(repository).save(post);
        doReturn(postList).when(repository).findPostsByPosterName("Test Poster");
    }
}
