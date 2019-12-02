package com.company.commentservice.repository;

import com.company.commentservice.model.Comment;
import com.company.commentservice.respository.CommentRepository;
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
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Before
    public void setUp() {
        List<Comment> commentList = commentRepository.findAll();
        commentList.forEach(comment -> commentRepository.deleteById(comment.getCommentId()));
    }

    @After
    public void tearDown() {
        List<Comment> commentList = commentRepository.findAll();
        commentList.forEach(comment -> commentRepository.deleteById(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment.setCommenterName("Test Commenter Name");
        comment.setComment("Test Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);
        comment = commentRepository.save(comment);

        assertEquals(comment.toString(), commentRepository.getOne(comment.getCommentId()).toString());
        commentRepository.deleteById(comment.getCommentId());
        assertEquals(0, commentRepository.findAll().size());
    }

    @Test
    public void shouldGetAllComments() {
        Comment comment = new Comment();
        comment.setCommenterName("Test Commenter Name");
        comment.setComment("Test Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);
        comment = commentRepository.save(comment);

        Comment comment2 = new Comment();
        comment2.setCommenterName("Test Commenter Name");
        comment2.setComment("Test Comment");
        comment2.setCreateDate(LocalDate.of(2019, 1, 1));
        comment2.setPostId(5);
        comment2 = commentRepository.save(comment2);

        assertEquals(2, commentRepository.findAll().size());
    }

    @Test
    public void shouldUpdateComment() {
        Comment comment = new Comment();
        comment.setCommenterName("Test Commenter Name");
        comment.setComment("Test Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);
        comment = commentRepository.save(comment);

        comment.setComment("New Test Comment");
        comment = commentRepository.save(comment);

        assertEquals("New Test Comment", commentRepository.getOne(comment.getCommentId()).getComment());
    }
}
