package com.company.edgeservice.model;

import java.util.Objects;

public class Room {

    private int id;
    private int number;
    private String occupant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOccupant() {
        return occupant;
    }

    public void setOccupant(String occupant) {
        this.occupant = occupant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id == room.id &&
                number == room.number &&
                Objects.equals(occupant, room.occupant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, occupant);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", occupant='" + occupant + '\'' +
                '}';
    }
}
