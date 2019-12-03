package com.company.crudservice.controller;

import com.company.crudservice.model.Room;
import com.company.crudservice.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudServiceController {

    @Autowired
    CrudRepository repository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() { return repository.findAll(); }

    @GetMapping("/rooms/{id}")
    public Room getRoomById(@PathVariable int id) {
        return repository.getOne(id);
    }

    @PostMapping("/rooms")
    public Room postRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @PutMapping("/rooms")
    public void putRoom(@RequestBody Room room) {
        repository.save(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable int id) {
        repository.deleteById(id);
    }
}
