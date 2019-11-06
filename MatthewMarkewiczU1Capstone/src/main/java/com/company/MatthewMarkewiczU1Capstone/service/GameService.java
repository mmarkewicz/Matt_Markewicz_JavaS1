package com.company.MatthewMarkewiczU1Capstone.service;

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

    public Game saveGame(Game game) {
        return gameDao.addGame(game);
    }

    public Game findGame(int id) {
        return gameDao.getGame(id);
    }

    public List<Game> findGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    public List<Game> findGamesByEsrbRating(String rating) {
        return gameDao.getGamesByEsrbRating(rating);
    }

    public List<Game> findGamesByTitle(String title) {
        return gameDao.getGamesByTitle(title);
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
