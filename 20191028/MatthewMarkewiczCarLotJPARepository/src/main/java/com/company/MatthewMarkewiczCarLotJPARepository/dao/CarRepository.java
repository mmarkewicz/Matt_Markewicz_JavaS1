package com.company.MatthewMarkewiczCarLotJPARepository.dao;

import com.company.MatthewMarkewiczCarLotJPARepository.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    public List<Car> findByMake(String make);
    public List<Car> findByColor(String color);
    public List<Car> findByMakeAndColor(String make, String color);
}
