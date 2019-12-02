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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment.setCommenterName("Test Commenter Name");
        comment.setComment("Test Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);
        comment = commentRepository.save(comment);

//        assertEquals(comment.toString(), commentRepository.getOne(comment.getCommentId()));
    }
}
