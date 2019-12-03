package com.company.crudservice.repository;

import com.company.crudservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Room, Integer> {
}
