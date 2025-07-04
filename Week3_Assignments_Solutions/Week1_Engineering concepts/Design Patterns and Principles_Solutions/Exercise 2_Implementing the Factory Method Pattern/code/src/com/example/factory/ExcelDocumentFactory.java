package com.example.factory;

import com.example.document.Document;
import com.example.document.ExcelDocument;

/**
 * A concrete factory for creating ExcelDocument objects.
 * It overrides the createDocument method to return an instance of ExcelDocument.
 */
public class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}