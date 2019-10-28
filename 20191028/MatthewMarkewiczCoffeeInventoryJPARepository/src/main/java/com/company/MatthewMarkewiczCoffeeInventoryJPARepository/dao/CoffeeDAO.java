package com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dao;

import com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeDAO extends JpaRepository<Coffee, Integer> {
}
