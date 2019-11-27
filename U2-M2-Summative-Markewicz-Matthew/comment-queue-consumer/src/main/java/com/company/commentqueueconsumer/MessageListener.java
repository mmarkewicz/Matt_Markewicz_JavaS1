package com.company.commentqueueconsumer;

import com.company.commentqueueconsumer.util.message.CommentMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(CommentMessage msg) {

    }
}
