package com.trlogyed.noteservice.models;

import java.util.Objects;

public class Note {
    int id;
    int book_id;
    String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note1 = (Note) o;
        return id == note1.id &&
                book_id == note1.book_id &&
                Objects.equals(note, note1.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book_id, note);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", note='" + note + '\'' +
                '}';
    }
}
