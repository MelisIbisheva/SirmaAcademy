package com.example.book_library.controller;

import com.example.book_library.model.Book;
import com.example.book_library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LibraryController {
    @Autowired
    private LibraryService service;

    @GetMapping("/books")
    public String viewBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("books", service.getBooks());
        return "books";

    }

    @PostMapping("/books")
    public String addBooks(@ModelAttribute Book book){
        service.addBook(book);
        return "redirect:/books";
    }
}
