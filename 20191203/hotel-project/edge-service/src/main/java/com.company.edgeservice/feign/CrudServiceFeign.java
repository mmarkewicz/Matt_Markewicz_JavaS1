package com.company.edgeservice.feign;

import com.company.edgeservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "crud-service")
public interface CrudServiceFeign {

    @GetMapping("/rooms")
    List<Room> getAllRooms();

    @PutMapping("/rooms")
    void putRoom(@RequestBody Room room);

}
