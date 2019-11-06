package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {
}
