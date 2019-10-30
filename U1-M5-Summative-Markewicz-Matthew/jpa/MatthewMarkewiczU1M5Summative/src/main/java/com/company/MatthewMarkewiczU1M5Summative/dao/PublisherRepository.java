package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.dto.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    // no custom methods
}
