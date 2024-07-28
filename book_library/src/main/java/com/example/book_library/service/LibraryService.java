package com.example.book_library.service;

import com.example.book_library.model.Book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    public CsvService csvService = new CsvService();

    public List<Book> getBooks(){
       return csvService.readBooks();

    }
//
//    public List<Magazine> getMagazines(){
//        return csvService.readMagazines();
//
//    }

    public void addBook(Book book){
        csvService.saveBook(book);
    }

//    public boolean addMagazines(Magazine magazine){
//        return csvService.saveMagazines(magazine);
//    }
}
