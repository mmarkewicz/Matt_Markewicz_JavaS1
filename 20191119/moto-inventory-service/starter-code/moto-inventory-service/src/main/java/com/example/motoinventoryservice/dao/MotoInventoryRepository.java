package com.example.motoinventoryservice.dao;

import com.example.motoinventoryservice.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoInventoryRepository extends JpaRepository<Motorcycle, Integer> {
    Motorcycle findByVin(String vin);
    List<Motorcycle> findByMake(String make);
}
