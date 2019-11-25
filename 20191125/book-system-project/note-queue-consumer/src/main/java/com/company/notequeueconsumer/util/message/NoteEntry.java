package com.company.notequeueconsumer.util.message;

import java.util.Objects;

public class NoteEntry {

    private int id;
    private int bookId;
    private String note;
    private String requestType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoteEntry)) return false;
        NoteEntry noteEntry = (NoteEntry) o;
        return id == noteEntry.id &&
                bookId == noteEntry.bookId &&
                Objects.equals(note, noteEntry.note) &&
                Objects.equals(requestType, noteEntry.requestType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, note, requestType);
    }

    @Override
    public String toString() {
        return "NoteEntry{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", note='" + note + '\'' +
                ", requestType='" + requestType + '\'' +
                '}';
    }
}
