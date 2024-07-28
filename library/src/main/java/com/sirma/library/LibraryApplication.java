package com.sirma.library;

import com.sirma.library.controller.BookController;
import com.sirma.library.model.Book;
import com.sirma.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	@Autowired
	BookController controller;


	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Library manager is running");

		controller.add(new Book("Foundation", new ArrayList<String>(){{add("Isak Asimov");}}, 1992));
		System.out.println(controller.getBooks());
		controller.add(new Book("1984", new ArrayList<String>(){{add("George Orwell");}}, 1984));
		System.out.println(controller.getBooks());
	}
}
