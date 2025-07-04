package com.example;

import com.example.factory.DocumentFactory;
import com.example.factory.ExcelDocumentFactory;
import com.example.factory.PdfDocumentFactory;
import com.example.factory.WordDocumentFactory;

/**
 * A test class to demonstrate the client's use of the Factory Method Pattern.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Document Management System ---");

        // The client code decides which factory to use at runtime.
        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("\nUsing Word Document Factory:");
        wordFactory.manageDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("\nUsing PDF Document Factory:");
        pdfFactory.manageDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("\nUsing Excel Document Factory:");
        excelFactory.manageDocument();

        System.out.println("\n--- System Shutdown ---");
    }
}