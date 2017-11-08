package com.rdhouse.creational.factorymethod;

import java.util.List;

import com.rdhouse.Demo;

/**
 * Factory Method Design Patter.
 * 
 * <b>Intent:<b>
 *  
 * Define an interface for creating an object, but let subclasses decide which class
 * to instantiate. Factory Method lets a class defer instantiation to subclasses.
 * 
 * <b>Paticipants:<b>
 * 
 * Product
 * ConcreteProduct
 * Creator
 * ConcreteCreator
 */
public class FactoryMethodDemo implements Demo {

    @Override
    public void run() {

    }

}

// The product definition
interface Document {

    void open();
    void close();

}

// The concrete products
class DrawingDocument implements Document {

    @Override
    public void open() {}

    @Override
    public void close() {}

}

class TextDocument implements Document {

    @Override
    public void open() {}

    @Override
    public void close() {}

}

// the creator definition
abstract class DocumentCreator {

    protected Document doc;

    // the factory method
    public abstract void createDocument();

    public void openDocument() {
        if (doc == null) {
            throw new IllegalStateException();
        }
        doc.open();
    }

    public void closeDocument() {
        if (doc == null) {
            throw new IllegalStateException();
        }
        doc.close();
    }
}

// The concrete creators
class DrawingDocumentCreator extends DocumentCreator {

    @Override
    public void createDocument() {
        doc = new DrawingDocument();
    }

}

class TextDocumentCreator extends DocumentCreator {

    @Override
    public void createDocument() {
        doc = new TextDocument();
    }

}
