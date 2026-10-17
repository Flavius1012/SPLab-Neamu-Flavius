package com.example.sp_lab.visitor_pattern;

import com.example.sp_lab.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenerateToC implements Visitor{

    private int pageCounter;

    private final Map<String, Integer> linie;

    public GenerateToC(){
        linie = new LinkedHashMap<>();
    }

    @Override
    public void visit(Book book) {
        pageCounter = 0;
        linie.clear();

        List<Element> elements = book.getElements();

        elements.forEach(e -> e.accept(this));

    }

    @Override
    public void visit(Section section) {
        linie.put(section.getTitle(), ++pageCounter);
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(Paragraph paragraph) {
        pageCounter++;
    }

    @Override
    public void visit(Image image) {
        pageCounter++;
    }

    @Override
    public void visit(Table table) {
        pageCounter++;
    }

    public void printToC(){
        for(Map.Entry<String, Integer> e : linie.entrySet())
            System.out.println(e.getKey() + "........" + e.getValue());

    }
}
