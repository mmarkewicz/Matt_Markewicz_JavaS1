package com.company.recordstore.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Record {

    // @NotEmpty is a JSR bean validation
    @NotEmpty(message = "error: you must submit an artist")
    private String artist;
    @NotEmpty(message = "error: you must submit an album")
    private String album;
    @NotEmpty(message = "error: you must submit a valid year")
    @Size(min = 4, max = 4, message = "error: year must be 4 digits")
    private String year;
    private int id;

    // default constructor which allows us to instantiate an object w/o parameters
    public Record() {}

    // constructor which accepts parameters
    public Record(String artist, String album, String year, int id) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.id = id;
    }

    // getters and setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // override the default equals method to verify equality
    @Override
    public boolean equals(Object o) {
        // if referencing the same object, return true
        if (this == o) {
            return true;
        }

        // if the object being checked is null, or not of the same class, return false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // cast the object being passed through
        Record record = (Record) o;

        // check each property of the objects
        return getId() == record.getId() &&
                Objects.equals(getArtist(), record.getArtist()) &&
                Objects.equals(getAlbum(), record.getAlbum()) &&
                Objects.equals(getYear(), record.getYear());
    }

    // override has code to include custom fields
    @Override
    public int hashCode() {
        return Objects.hash(getArtist(), getAlbum(), getYear(), getId());
    }
}
