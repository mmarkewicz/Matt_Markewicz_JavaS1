package com.company.stwitterservice.controller;

import com.company.stwitterservice.feign.PostServiceFeign;
import com.company.stwitterservice.model.Comment;
import com.company.stwitterservice.model.Post;
import com.company.stwitterservice.model.PostViewModel;
import com.company.stwitterservice.service.StwitterServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StwitterController.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @MockBean
    private PostServiceFeign postServiceFeign;

    @MockBean
    private StwitterServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnListOfPostsFromGetAllPosts() throws Exception {
        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment");

        Post responsePost = new Post();
        responsePost.setPostID(5);
        responsePost.setPosterName("Test Poster Name");
        responsePost.setPost("Test Post");
        responsePost.setPostDate(LocalDate.of(2019, 1, 1));
        responsePost.setComments(commentList);

        when(service.getPost(anyInt())).thenReturn(responsePost);

        this.mockMvc.perform(get("/posts/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Poster Name")));
    }

    @Test
    public void shouldReturnListOfPostsFromGetPostsByUser() throws Exception {
        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment");

        Post responsePost = new Post();
        responsePost.setPostID(5);
        responsePost.setPosterName("Test Poster Name");
        responsePost.setPost("Test Post");
        responsePost.setPostDate(LocalDate.of(2019, 1, 1));
        responsePost.setComments(commentList);

        List<Post> postList = new ArrayList<>();
        postList.add(responsePost);

        when(service.getPostsByPoster(anyString())).thenReturn(postList);

        this.mockMvc.perform(get("/posts/user/Test Poster Name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Poster Name")));
    }

    @Test
    public void shouldReturnPostFromAddPost() throws Exception {
        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment");

        Post responsePost = new Post();
        responsePost.setPostID(5);
        responsePost.setPosterName("Test Poster Name");
        responsePost.setPost("Test Post");
        responsePost.setPostDate(LocalDate.of(2019, 1, 1));
        responsePost.setComments(commentList);

        Comment comment = new Comment();
        comment.setComment("Test Comment");
        comment.setCommenterName("Test Commenter Name");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));

        List<Comment> commentObjectList = new ArrayList<>();
        commentObjectList.add(comment);

        PostViewModel requestPostViewModel = new PostViewModel();
        requestPostViewModel.setPosterName("Test Poster Name");
        requestPostViewModel.setPost("Test Post");
        requestPostViewModel.setPostDate(LocalDate.of(2019, 1, 1));
        requestPostViewModel.setComments(commentObjectList);

        when(service.createPost(any(PostViewModel.class))).thenReturn(responsePost);

        String json = mapper.writeValueAsString(requestPostViewModel);

        this.mockMvc.perform(
                post("/posts")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Poster Name")));
    }
}
