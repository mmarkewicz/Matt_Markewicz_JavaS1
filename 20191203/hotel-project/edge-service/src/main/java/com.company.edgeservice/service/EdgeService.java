package com.company.edgeservice.service;

import com.company.edgeservice.feign.CrudServiceFeign;
import com.company.edgeservice.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeService {

    @Autowired
    CrudServiceFeign crudServiceFeign;

    public List<Room> getAllRooms() {
        return crudServiceFeign.getAllRooms();
    }

    public void updateRoomOccupant(Room room) {
        crudServiceFeign.putRoom(room);
    }
}
