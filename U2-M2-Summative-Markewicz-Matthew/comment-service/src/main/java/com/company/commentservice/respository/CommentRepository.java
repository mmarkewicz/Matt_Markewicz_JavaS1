package com.company.commentservice.respository;

import com.company.commentservice.model.Comment;
import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {}
