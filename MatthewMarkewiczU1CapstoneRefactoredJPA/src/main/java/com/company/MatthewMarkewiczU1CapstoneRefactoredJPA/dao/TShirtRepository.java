package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.TShirt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TShirtRepository {
    List<TShirt> findByColor(String color);
    List<TShirt> findBySize(String size);
}
