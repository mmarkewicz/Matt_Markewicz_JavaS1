package com.company.edgeservice.controller;

import com.company.edgeservice.model.Room;
import com.company.edgeservice.service.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EdgeServiceController {

    @Autowired
    EdgeService service;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return service.getAllRooms();
    }

    @PutMapping("/rooms")
    public void putRoom(@RequestBody Room room) {
        service.updateRoomOccupant(room);
    }
}
