package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.GameDao;
import com.company.MatthewMarkewiczU1Capstone.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    GameService gameService;

    @Mock
    GameDao gameDao;

    @Before
    public void setUp() {
        setUpGameMocks();

        gameService = new GameService(gameDao);
    }

    @Test
    public void shouldAddNewGameFromServiceLayer() {
        Game gameOne = new Game();
        gameOne.setTitle("Halo");
        gameOne.setStudio("Bungie");
        gameOne.setEsrbRating("M");
        gameOne.setPrice(new BigDecimal(39.99));
        gameOne.setDescription("The OG Halo");
        gameOne.setQuantity(10);

        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        assertEquals(gameOneFromDb, gameService.saveGame(gameOne));
    }

    @Test
    public void shouldGetGameFromServiceLayer() {
        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        assertEquals(gameOneFromDb, gameService.findGame(11));
    }

    @Test
    public void shouldGetGameListFromServiceLayer() {
        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        List<Game> gameList = new ArrayList<>();
        gameList.add(gameOneFromDb);

        assertEquals(gameList, gameService.findAllGames());
    }

    @Test
    public void shouldGetGameListByTitle() {
        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        List<Game> gameList = new ArrayList<>();
        gameList.add(gameOneFromDb);

        assertEquals(gameList, gameService.findGamesByTitle("Halo"));
    }

    @Test
    public void shouldGetGameListByEsrb() {
        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        List<Game> gameList = new ArrayList<>();
        gameList.add(gameOneFromDb);

        assertEquals(gameList, gameService.findGamesByEsrbRating("M"));
    }

    @Test
    public void shouldGetGameListByStudio() {
        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        List<Game> gameList = new ArrayList<>();
        gameList.add(gameOneFromDb);

        assertEquals(gameList, gameService.findGamesByStudio("Bungie"));
    }

    @Test
    public void shouldReturnNullWhenSearchingForInvalidId() {
        assertNull(gameService.findGame(1000000));
    }

    @Test
    public void shouldReturnEmptyList() {
        List<Game> gameList = new ArrayList<>();

        assertEquals(gameList, gameService.findGamesByStudio("Nope"));
        assertEquals(gameList, gameService.findGamesByEsrbRating("NA"));
        assertEquals(gameList, gameService.findGamesByTitle("None"));
    }

    public void setUpGameMocks() {
        Game gameOne = new Game();
        gameOne.setTitle("Halo");
        gameOne.setStudio("Bungie");
        gameOne.setEsrbRating("M");
        gameOne.setPrice(new BigDecimal(39.99));
        gameOne.setDescription("The OG Halo");
        gameOne.setQuantity(10);

        Game gameOneFromDb = new Game();
        gameOneFromDb.setTitle("Halo");
        gameOneFromDb.setStudio("Bungie");
        gameOneFromDb.setEsrbRating("M");
        gameOneFromDb.setPrice(new BigDecimal(39.99));
        gameOneFromDb.setDescription("The OG Halo");
        gameOneFromDb.setQuantity(10);
        gameOneFromDb.setGameId(11);

        List<Game> gameList = new ArrayList<>();
        gameList.add(gameOneFromDb);

        doReturn(gameOneFromDb).when(gameDao).addGame(gameOne);
        doReturn(gameOneFromDb).when(gameDao).getGame(11);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getGamesByTitle("Halo");
        doReturn(gameList).when(gameDao).getGamesByEsrbRating("M");
        doReturn(gameList).when(gameDao).getGamesByStudio("Bungie");
    }
}
