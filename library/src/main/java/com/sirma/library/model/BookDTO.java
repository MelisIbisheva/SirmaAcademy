package com.sirma.library.model;

public class BookDTO {
    private String name;
    private int year;

    public BookDTO(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return  name + " - " + year ;
    }
}
