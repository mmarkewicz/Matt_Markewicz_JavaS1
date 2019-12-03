package com.company.postservice.controller;

import com.company.postservice.model.Post;
import com.company.postservice.service.PostServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnPostListFromGetAllPosts() throws Exception {
        Post post = new Post();
        post.setPostID(5);
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        post.setPostDate(LocalDate.of(2019, 1, 1));

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        when(service.getAllPosts()).thenReturn(postList);

        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Post")));
    }

    @Test
    public void shouldReturnPostFromGetPostById() throws Exception {
        Post post = new Post();
        post.setPostID(5);
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        post.setPostDate(LocalDate.of(2019, 1, 1));

        when(service.getPostById(5)).thenReturn(post);

        this.mockMvc.perform(get("/post/id/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Post")));
    }

    @Test
    public void shouldReturnPostFromPostPost() throws Exception {
        Post post = new Post();
        post.setPostID(5);
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        post.setPostDate(LocalDate.of(2019, 1, 1));

        Post postWithoutId = new Post();
        post.setPosterName("Test Poster Name");
        post.setPost("Test Post");
        post.setPostDate(LocalDate.of(2019, 1, 1));

        when(service.postPost(postWithoutId)).thenReturn(post);

        String json = mapper.writeValueAsString(postWithoutId);

        this.mockMvc.perform(
                post("/posts")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Post")));
    }
}
