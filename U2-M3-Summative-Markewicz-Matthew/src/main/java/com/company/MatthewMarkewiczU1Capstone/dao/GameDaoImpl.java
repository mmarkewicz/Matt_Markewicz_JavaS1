package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoImpl implements GameDao {

    private static final String INSERT_GAME_SQL =
            "INSERT INTO game (title, esrb_rating, description, price, studio, quantity) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";

    private static final String SELECT_GAME_BY_STUDIO_SQL =
            "SELECT * FROM game WHERE studio = ?";

    private static final String SELECT_GAME_BY_ESRB_RATING_SQL =
            "SELECT * FROM game WHERE esrb_rating = ?";

    private static final String SELECT_GAME_BY_TITLE_SQL =
            "SELECT * FROM game WHERE title = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "SELECT * FROM game";

    private static final String UPDATE_GAME_SQL =
            "UPDATE game SET title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? WHERE game_id = ?";

    private static final String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity()
                );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(id);
        return game;
    }

    @Override
    public Game getGame(int id) {
        return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
    }

    public List<Game> getGamesByStudio(String studio) { return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio); }

    public List<Game> getGamesByEsrbRating(String esrbRating) { return jdbcTemplate.query(SELECT_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame, esrbRating); }

    public List<Game> getGamesByTitle(String title) { return jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToGame, title); }
    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId()
                );
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setDescription(rs.getString("description"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setQuantity(rs.getInt("quantity"));
        game.setStudio(rs.getString("studio"));
        game.setTitle(rs.getString("title"));
        return game;
    }
}
