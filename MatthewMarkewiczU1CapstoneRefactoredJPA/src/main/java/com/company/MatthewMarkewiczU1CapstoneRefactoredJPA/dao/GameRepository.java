package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository {
    List<Game> findGamesByStudio(String studio);
    List<Game> findGamesByEsrb_rating(String esrbRating);
    List<Game> findGamesByTitle(String title);
}
