package com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="roaster")
public class Roaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roster_id;
    private String make;
    private String location;

    public Integer getRoster_id() {
        return roster_id;
    }

    public void setRoster_id(Integer roster_id) {
        this.roster_id = roster_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roaster)) return false;
        Roaster roaster = (Roaster) o;
        return Objects.equals(roster_id, roaster.roster_id) &&
                Objects.equals(make, roaster.make) &&
                Objects.equals(location, roaster.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roster_id, make, location);
    }
}
