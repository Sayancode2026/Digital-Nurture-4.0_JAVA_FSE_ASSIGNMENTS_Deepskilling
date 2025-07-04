// src/main/java/com/library/service/BookService.java
package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    // Constructor for dependency injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService initialized with BookRepository.");
    }

    // Setter for dependency injection (if using property injection in XML)
    // public void setBookRepository(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    public List<String> getAllBooks() {
        System.out.println("BookService: Requesting all books from repository.");
        return bookRepository.findAllBooks();
    }

    public void addNewBook(String title) {
        System.out.println("BookService: Adding new book - " + title);
        bookRepository.addBook(title);
    }
}
