package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() {
        List<Game> gameList = gameDao.getAllGames();
        gameList.stream()
                .forEach(game -> gameDao.deleteGame(game.getGameId()));
    }

    @After
    public void tearDown() {
        List<Game> gameList = gameDao.getAllGames();
        gameList.stream()
                .forEach(game -> gameDao.deleteGame(game.getGameId()));
    }

    @Test
    public void addGetDeleteGames() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setStudio("Test Studio");
        game.setQuantity(10);
        game.setPrice(new BigDecimal(59.99));
        game.setEsrbRating("E");
        game.setDescription("Testing Testing");
        game = gameDao.addGame(game);
        game.setPrice(game.getPrice().setScale(2, RoundingMode.HALF_EVEN));

        Game testGame = gameDao.getGame(game.getGameId());
        assertEquals(game, testGame);

        gameDao.deleteGame(game.getGameId());
        assertEquals(gameDao.getAllGames().size(), 0);
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setStudio("Test Studio");
        game.setQuantity(10);
        game.setPrice(new BigDecimal(59.99));
        game.setEsrbRating("E");
        game.setDescription("Testing Testing");
        game = gameDao.addGame(game);
        game.setPrice(game.getPrice().setScale(2, RoundingMode.HALF_EVEN));

        game.setEsrbRating("M");
        gameDao.updateGame(game);

        assertEquals(gameDao.getGame(game.getGameId()).getEsrbRating(), "M");
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setStudio("Test Studio");
        game.setQuantity(10);
        game.setPrice(new BigDecimal(59.99));
        game.setEsrbRating("E");
        game.setDescription("Testing Testing");
        game = gameDao.addGame(game);
        game.setPrice(game.getPrice().setScale(2, RoundingMode.HALF_EVEN));

        assertEquals(gameDao.getAllGames().size(), 1);
    }

    @Test
    public void getGameByStudio() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setStudio("Test Studio");
        game.setQuantity(10);
        game.setPrice(new BigDecimal(59.99));
        game.setEsrbRating("E");
        game.setDescription("Testing Testing");
        gameDao.addGame(game);

        List<Game> gameList = gameDao.getGamesByStudio("Test Studio");

        assertEquals(gameList.get(0).getStudio(), "Test Studio");
    }

    @Test
    public void getGameByEsrbRating() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setStudio("Test Studio");
        game.setQuantity(10);
        game.setPrice(new BigDecimal(59.99));
        game.setEsrbRating("E");
        game.setDescription("Testing Testing");
        gameDao.addGame(game);

        List<Game> gameList = gameDao.getGamesByEsrbRating("E");

        assertEquals(gameList.get(0).getEsrbRating(), "E");
    }

    @Test
    public void getGamesByTitle() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setStudio("Test Studio");
        game.setQuantity(10);
        game.setPrice(new BigDecimal(59.99));
        game.setEsrbRating("E");
        game.setDescription("Testing Testing");
        gameDao.addGame(game);

        List<Game> gameList = gameDao.getGamesByTitle("Test Game");

        assertEquals(gameList.get(0).getTitle(), "Test Game");
    }
}
