package com.company.commentservice.service;

import com.company.commentservice.model.Comment;
import com.company.commentservice.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceLayer {

    @Autowired
    CommentRepository commentRepository;

    public CommentServiceLayer(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentServiceLayer() {}

    public Comment findCommentById(int id) {
        return commentRepository.getOne(id);
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void updateComment(Comment comment) throws Exception {
        if (commentRepository.getOne(comment.getCommentId()) == null) {
            throw new Exception("Cannot update that comment because that ID is not in the database.");
        } else {
            commentRepository.save(comment);
        }
    }

    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }
}
