package com.sirma.library.service;

import com.sirma.library.model.Book;
import com.sirma.library.model.BookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public List<BookDTO> findAll(){
        return books.stream().map(e-> new BookDTO(e.getName(), e.getYear())).toList();

    }
    public boolean addBook(Book book){
       return this.books.add(book);

    }
}
