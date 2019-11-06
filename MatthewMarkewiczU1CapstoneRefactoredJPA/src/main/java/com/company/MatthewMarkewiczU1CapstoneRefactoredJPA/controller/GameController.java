package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.controller;

import com.company.MatthewMarkewiczU1Capstone.dto.Game;
import com.company.MatthewMarkewiczU1Capstone.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(value = "/games")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGames() {
        return gameService.findAllGames();
    }

    @GetMapping(value = "/games/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id) throws Exception {
        return gameService.findGame(id);
    }

    @GetMapping(value = "/games/studio/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) throws Exception {
        return gameService.findGamesByStudio(studio);
    }

    @GetMapping(value = "/games/esrb/{rating}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByEsrbRating(@PathVariable String rating) throws Exception {
        return gameService.findGamesByEsrbRating(rating);
    }

    @GetMapping(value = "/games/title/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) throws Exception {
        return gameService.findGamesByTitle(title);
    }

    @PostMapping(value = "/games")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game postGame(@RequestBody Game game) throws Exception {
        return gameService.saveGame(game);
    }

    @PutMapping(value = "/games")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void putGame(@RequestBody Game game) {
        gameService.updateGame(game);
    }

    @DeleteMapping(value = "/games/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }
}
