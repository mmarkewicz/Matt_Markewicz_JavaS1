package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate, Integer> {
}
