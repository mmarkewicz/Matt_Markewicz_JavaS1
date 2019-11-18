package com.trilogyed.emaillistqueueconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.trilogyed.emaillistqueueconsumer.util.messages.EmailListEntry;

@Service
public class MessageListener {
    @RabbitListener(queues = EmailListQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(EmailListEntry msg) {
        System.out.println(msg.toString());
    }
}
