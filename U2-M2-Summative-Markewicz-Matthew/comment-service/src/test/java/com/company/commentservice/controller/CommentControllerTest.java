package com.company.commentservice.controller;

import com.company.commentservice.model.Comment;
import com.company.commentservice.service.CommentServiceLayer;
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
@WebMvcTest(CommentController.class)
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnCommentListFromGetAllComments() throws Exception {
        Comment comment = new Comment();
        comment.setCommentId(5);
        comment.setCommenterName("Test Commenter");
        comment.setComment("Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        when(service.findAllComments()).thenReturn(commentList);

        this.mockMvc.perform(get("/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Commenter")));
    }

    @Test
    public void shouldReturnCommentFromGetCommentById() throws Exception {
        Comment comment = new Comment();
        comment.setCommentId(5);
        comment.setCommenterName("Test Commenter");
        comment.setComment("Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);

        when(service.findCommentById(5)).thenReturn(comment);

        this.mockMvc.perform(get("/comment/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Commenter")));
    }

    @Test
    public void shouldReturnCommentFromPostComment() throws Exception {
        Comment commentWithoutId = new Comment();
        commentWithoutId.setCommenterName("Test Commenter");
        commentWithoutId.setComment("Comment");
        commentWithoutId.setCreateDate(LocalDate.of(2019, 1, 1));
        commentWithoutId.setPostId(5);

        Comment comment = new Comment();
        comment.setCommentId(5);
        comment.setCommenterName("Test Commenter");
        comment.setComment("Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);

        when(service.addComment(commentWithoutId)).thenReturn(comment);

        String json = mapper.writeValueAsString(commentWithoutId);
        this.mockMvc.perform(
                    post("/comments")
                            .content(json)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                            .characterEncoding("utf-8")
                    )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Commenter")));
    }

}
