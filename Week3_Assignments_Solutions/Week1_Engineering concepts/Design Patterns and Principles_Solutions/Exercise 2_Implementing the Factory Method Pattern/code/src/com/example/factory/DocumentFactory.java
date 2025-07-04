package com.example.factory;

import com.example.document.Document;

/**
 * Declares the factory method, which returns an object of type Document.
 * Subclasses of DocumentFactory will provide the actual implementation of this method,
 * creating specific document instances.
 */
public abstract class DocumentFactory {

    /**
     * This is the core factory method. Subclasses must override this to create specific
     * document objects.
     *
     * @return A new Document instance.
     */
    public abstract Document createDocument();

    /**
     * This is a convenience method that uses the factory method to create and manage a document.
     * Client code can call this method to get a fully handled document without knowing the
     * concrete implementation details.
     */
    public void manageDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}