package com.library.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {

    private final List<String> books = new ArrayList<>(Arrays.asList(
        "The Great Gatsby",
        "1984",
        "To Kill a Mockingbird"
    ));

    public BookRepository() {
        System.out.println("BookRepository initialized. Available books: " + books.size());
    }

    public void saveBook(String title) {
        books.add(title);
        System.out.println("BookRepository: Added book - " + title);
    }

    public List<String> getAllBooks() {
        System.out.println("BookRepository: Fetching all books.");
        return new ArrayList<>(books); // Return a copy to prevent external modification
    }
}