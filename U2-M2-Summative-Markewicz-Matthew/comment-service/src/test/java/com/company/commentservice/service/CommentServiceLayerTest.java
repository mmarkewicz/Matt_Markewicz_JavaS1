package com.company.commentservice.service;

import com.company.commentservice.model.Comment;
import com.company.commentservice.respository.CommentRepository;
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
public class CommentServiceLayerTest {

    CommentServiceLayer service;

    @Mock
    CommentRepository commentRepository;

    @Before
    public void setUp() {
        setUpMocks();
        service = new CommentServiceLayer(commentRepository);
    }

    @Test
    public void shouldReturnCommentAfterAdding() {
        Comment comment = new Comment();
        comment.setComment("Test Comment");
        comment.setPostId(5);
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setCommenterName("Test Commenter");

        Comment commentFromDb = new Comment();
        commentFromDb.setCommentId(5);
        commentFromDb.setComment("Test Comment");
        commentFromDb.setPostId(5);
        commentFromDb.setCreateDate(LocalDate.of(2019, 1, 1));
        commentFromDb.setCommenterName("Test Commenter");

        assertEquals(service.addComment(comment).toString(), commentFromDb.toString());
    }

    @Test
    public void shouldReturnCommentFromFindById() {
        Comment commentFromDb = new Comment();
        commentFromDb.setCommentId(5);
        commentFromDb.setComment("Test Comment");
        commentFromDb.setPostId(5);
        commentFromDb.setCreateDate(LocalDate.of(2019, 1, 1));
        commentFromDb.setCommenterName("Test Commenter");

        assertEquals(service.findCommentById(commentFromDb.getCommentId()).toString(), commentFromDb.toString());
    }

    @Test
    public void shouldReturnListOfCommentsFromFindAllComments() {
        Comment commentFromDb = new Comment();
        commentFromDb.setCommentId(5);
        commentFromDb.setComment("Test Comment");
        commentFromDb.setPostId(5);
        commentFromDb.setCreateDate(LocalDate.of(2019, 1, 1));
        commentFromDb.setCommenterName("Test Commenter");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(commentFromDb);

        assertEquals(service.findAllComments().get(0).toString(), commentFromDb.toString());
    }

    public void setUpMocks() {
        Comment commentFromDb = new Comment();
        commentFromDb.setCommentId(5);
        commentFromDb.setComment("Test Comment");
        commentFromDb.setPostId(5);
        commentFromDb.setCreateDate(LocalDate.of(2019, 1, 1));
        commentFromDb.setCommenterName("Test Commenter");

        Comment comment = new Comment();
        comment.setComment("Test Comment");
        comment.setPostId(5);
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setCommenterName("Test Commenter");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(commentFromDb);

        doReturn(commentFromDb).when(commentRepository).getOne(5);
        doReturn(commentList).when(commentRepository).findAll();
        doReturn(commentFromDb).when(commentRepository).save(comment);
    }
}
