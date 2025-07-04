package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository; // This will be injected by Spring

    // Setter method for BookRepository - REQUIRED for setter-based DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService initialized with BookRepository.");
    }

    public void addNewBook(String title) {
        if (bookRepository != null) {
            System.out.println("BookService: Adding new book - " + title);
            bookRepository.saveBook(title);
        } else {
            System.out.println("BookRepository not injected! Cannot add book.");
        }
    }

    public List<String> getAllBooks() {
        if (bookRepository != null) {
            System.out.println("BookService: Requesting all books from repository.");
            return bookRepository.getAllBooks();
        } else {
            System.out.println("BookRepository not injected! Cannot display books.");
            return List.of(); // Return an empty list
        }
    }
}