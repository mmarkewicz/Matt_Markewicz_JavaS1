package com.company.notequeueconsumer;

import com.company.notequeueconsumer.feign.NoteFeignClient;
import com.company.notequeueconsumer.models.Note;
import com.company.notequeueconsumer.util.message.NoteEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@Service
@EnableFeignClients
public class MessageListener {

    @Autowired
    NoteFeignClient noteFeignClient;

    @RabbitListener(queues = NoteQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(NoteEntry msg) {
        Note note = new Note();
        note.setId(msg.getId());
        note.setBook_id(msg.getBookId());
        note.setNote(msg.getNote());
        if (msg.getRequestType() == "POST") {
            noteFeignClient.addNote(note);
            System.out.println("Note Added");
        }

    }
}
