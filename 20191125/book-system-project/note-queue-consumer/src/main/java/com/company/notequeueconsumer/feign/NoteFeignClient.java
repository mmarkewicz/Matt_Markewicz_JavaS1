package com.company.notequeueconsumer.feign;

import com.company.notequeueconsumer.models.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "note-service")
public interface NoteFeignClient {

    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note);
}
