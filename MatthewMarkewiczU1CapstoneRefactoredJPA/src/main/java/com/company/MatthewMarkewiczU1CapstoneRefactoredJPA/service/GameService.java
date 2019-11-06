package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

import com.company.MatthewMarkewiczU1Capstone.dao.GameDao;
import com.company.MatthewMarkewiczU1Capstone.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameDao gameDao;

    @Autowired
    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public Game saveGame(Game game) throws Exception {
        try {
            return gameDao.addGame(game);
        } catch (Exception e) {
            throw new Exception("Game could not be added");
        }
    }

    public Game findGame(int id) throws Exception {
        try {
            return gameDao.getGame(id);
        } catch (Exception e) {
            throw new Exception("A game with that ID is not in the database");
        }
    }

    public List<Game> findGamesByStudio(String studio) throws Exception {
        try {
            return gameDao.getGamesByStudio(studio);
        } catch (Exception e) {
            throw new Exception("No games with that studio");
        }
    }

    public List<Game> findGamesByEsrbRating(String rating) throws Exception {
        try {
            return gameDao.getGamesByEsrbRating(rating);
        } catch (Exception e) {
            throw new Exception("No games with that rating");
        }
    }

    public List<Game> findGamesByTitle(String title) throws Exception {
        try {
            return gameDao.getGamesByTitle(title);
        } catch (Exception e) {
            throw new Exception("No games with that title");
        }
    }

    public List<Game> findAllGames() {
        return gameDao.getAllGames();
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public void deleteGame(int id) {
        gameDao.deleteGame(id);
    }
}
