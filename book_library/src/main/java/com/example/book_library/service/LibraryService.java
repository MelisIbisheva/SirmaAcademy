package com.example.book_library.service;

import com.example.book_library.model.Book;

import com.example.book_library.model.Magazine;
import com.example.book_library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private BookRepository bookRepository;
    private CsvService csvService = new CsvService();

    public List<Book> getBooks(){
      // return csvService.readBooks();
       return bookRepository.findAll();

    }

    public List<Magazine> getMagazines(){
        return csvService.readMagazines();

    }

    public void addBook(Book book){
        //csvService.saveBook(book);
        bookRepository.save(book);
    }

    public void addMagazines(Magazine magazine){
         csvService.saveMagazine(magazine);
    }
}
