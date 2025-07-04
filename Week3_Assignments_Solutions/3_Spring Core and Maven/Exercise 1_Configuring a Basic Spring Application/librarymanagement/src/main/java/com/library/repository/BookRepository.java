
package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books; // Simple in-memory storage for demonstration

    public BookRepository() {
        this.books = new ArrayList<>();
        this.books.add("The Great Gatsby");
        this.books.add("1984");
        this.books.add("To Kill a Mockingbird");
        System.out.println("BookRepository initialized. Available books: " + books.size());
    }

    public List<String> findAllBooks() {
        System.out.println("BookRepository: Fetching all books.");
        return new ArrayList<>(books); // Return a copy to prevent external modification
    }

    public void addBook(String bookTitle) {
        this.books.add(bookTitle);
        System.out.println("BookRepository: Added book - " + bookTitle);
    }
}
