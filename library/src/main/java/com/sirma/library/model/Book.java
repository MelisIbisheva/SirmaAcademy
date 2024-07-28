package com.sirma.library.model;

import java.util.List;

public class Book {
    private String name;
    private List<String> authors;
    private int year;
//    private String[] genres;


    public Book() {

    }

    public Book(String name, List<String> authors, int year) {
        this.name = name;
        this.authors = authors;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + authors +
                ", year=" + year +
                '}';
    }
}
