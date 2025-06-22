package com.example.factory;

import com.example.document.Document;
import com.example.document.WordDocument;

/**
 * A concrete factory for creating WordDocument objects.
 * It overrides the createDocument method to return an instance of WordDocument.
 */
public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}