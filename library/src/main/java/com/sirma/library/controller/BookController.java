package com.sirma.library.controller;

import com.sirma.library.model.Book;
import com.sirma.library.model.BookDTO;
import com.sirma.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    public List<BookDTO> getBooks(){
        //validated Authorization
        // validated Authentication
        // request format
        return service.findAll();

    }
    public boolean add(Book book){
        return service.addBook(book);
    }
}
