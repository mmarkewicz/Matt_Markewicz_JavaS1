package com.company.CarLotDAOMatthewMarkewicz.dao;

import com.company.CarLotDAOMatthewMarkewicz.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarLotImpl implements CarLotDAO {

    //  private int id;
    //    private String make;
    //    private String model;
    //    private String year;
    //    private String color;

    // prepared statement strings
    private static final String INSERT_CAR_SQL =
            "INSERT INTO car (make, model, year, color) VALUES (?, ?, ?, ?)";

    private static final String SELECT_CAR_SQL =
            "SELECT * FROM car WHERE id = ?";

    private static final String SELECT_ALL_CARS_SQL =
            "SELECT * FROM car";

    private static final String UPDATE_CAR_SQL =
            "UPDATE car SET make = ?, model = ?, year = ?, color = ? WHERE id = ?";

    private static final String DELETE_CAR_SQL =
            "DELETE FROM car WHERE id = ?";

    private static final String SELECT_CARS_BY_MAKE =
            "SELECT * FROM car WHERE make = ?";

    private static final String SELECT_CARS_BY_COLOR =
            "SELECT * FROM car WHERE color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarLotImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Car getCar(int id) {
        return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
    }

    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCar(int id) {

    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return jdbcTemplate.query(SELECT_CARS_BY_MAKE, this::mapRowToCar, make);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return jdbcTemplate.query(SELECT_CARS_BY_COLOR, this::mapRowToCar, color);
    }

    // Helper methods
    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));
        return car;
    }
}
