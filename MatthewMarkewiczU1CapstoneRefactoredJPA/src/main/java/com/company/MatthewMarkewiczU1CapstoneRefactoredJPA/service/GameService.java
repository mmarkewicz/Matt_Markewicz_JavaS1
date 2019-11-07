package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao.GameRepository;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGame(Game game) throws Exception {
        try {
            return gameRepository.save(game);
        } catch (Exception e) {
            throw new Exception("Game could not be added");
        }
    }

    public Game findGame(int id) throws Exception {
        try {
            return gameRepository.getOne(id);
        } catch (Exception e) {
            throw new Exception("A game with that ID is not in the database");
        }
    }

    public List<Game> findGamesByStudio(String studio) throws Exception {
        try {
            return gameRepository.findGamesByStudio(studio);
        } catch (Exception e) {
            throw new Exception("No games with that studio");
        }
    }

    public List<Game> findGamesByEsrbRating(String rating) throws Exception {
        try {
            return gameRepository.findGamesByEsrbRating(rating);
        } catch (Exception e) {
            throw new Exception("No games with that rating");
        }
    }

    public List<Game> findGamesByTitle(String title) throws Exception {
        try {
            return gameRepository.findGamesByTitle(title);
        } catch (Exception e) {
            throw new Exception("No games with that title");
        }
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public void updateGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }
}
