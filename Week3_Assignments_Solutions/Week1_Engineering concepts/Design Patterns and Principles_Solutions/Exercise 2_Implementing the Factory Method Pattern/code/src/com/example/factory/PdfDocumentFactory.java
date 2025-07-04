package com.example.factory;

import com.example.document.Document;
import com.example.document.PdfDocument;

/**
 * A concrete factory for creating PdfDocument objects.
 * It overrides the createDocument method to return an instance of PdfDocument.
 */
public class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}