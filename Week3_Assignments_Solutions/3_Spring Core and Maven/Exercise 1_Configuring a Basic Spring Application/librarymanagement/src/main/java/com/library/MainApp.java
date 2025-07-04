
package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List; 

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Starting Spring Application...");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring ApplicationContext loaded successfully.");

       
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println("BookService bean retrieved.");

        // Use the BookService to perform operations
        System.out.println("\n--- Listing initial books ---");
        List<String> books = bookService.getAllBooks();
        books.forEach(System.out::println);

        System.out.println("\n--- Adding a new book ---");
        bookService.addNewBook("The Hobbit");

        System.out.println("\n--- Listing books after adding new one ---");
        books = bookService.getAllBooks();
        books.forEach(System.out::println);

        // Close the context (important for proper shutdown, especially in web apps)
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("\nSpring Application finished.");
    }
}
