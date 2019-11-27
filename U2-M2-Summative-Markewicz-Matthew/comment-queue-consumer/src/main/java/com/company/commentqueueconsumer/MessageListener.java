package com.company.commentqueueconsumer;

import com.company.commentqueueconsumer.feign.CommentServiceFeign;
import com.company.commentqueueconsumer.model.Comment;
import com.company.commentqueueconsumer.util.message.CommentMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentServiceFeign commentServiceFeign;

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(CommentMessage msg) {
        Comment comment = new Comment();
        comment.setCommenterName(msg.getCommenterName());
        comment.setComment(msg.getComment());
        comment.setCreateDate(msg.getCreateDate());
        comment.setPostId(msg.getPostId());

        commentServiceFeign.postComment(comment);
        System.out.println("Comment Posted");
    }
}
