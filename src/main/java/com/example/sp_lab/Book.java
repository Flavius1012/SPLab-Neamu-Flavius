package com.example.sp_lab;

import java.util.ArrayList;
import java.util.List;


public class Book{

    private final List<Element> elements;
    private final List<Author> authors;

    public Book(){
        elements = new ArrayList<>();
        authors = new ArrayList<>();
    }

    public void print() {
        for(Element e : elements)
            e.print();
    }

    public void add(Element e) {
        elements.add(e);
    }

    public void remove(Element e) {
        elements.remove(e);
    }

    public Element get(int index) {
        return elements.get(index);
    }

    public void addAuthor(Author a){
        authors.add(a);
    }
}
