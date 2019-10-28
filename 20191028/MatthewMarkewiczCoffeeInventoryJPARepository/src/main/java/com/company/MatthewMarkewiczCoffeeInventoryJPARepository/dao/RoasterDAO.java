package com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dao;

import com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterDAO extends JpaRepository<Roaster, Integer> {
}
