package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.dto.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // no custom methods
}
