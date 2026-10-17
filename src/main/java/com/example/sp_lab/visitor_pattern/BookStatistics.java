package com.example.sp_lab.visitor_pattern;

import com.example.sp_lab.*;

public class BookStatistics implements Visitor {

    int sections, paragraphs, images, tables;

    public BookStatistics(){
        sections = 0;
        paragraphs = 0;
        images = 0;
        tables = 0;
    }

    @Override
    public void visit(Book book) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(Section section) {
        sections++;
    }

    @Override
    public void visit(TableOfContents tableOfContents) {

    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraphs++;
    }

    @Override
    public void visit(Image image) {
        images++;
    }

    @Override
    public void visit(Table table) {
        tables++;
    }

    public void printStatistics(){
        System.out.println("Number of images: " + images);
        System.out.println("Number of tables: " + tables);
        System.out.printf("Number of paragraphs: " + paragraphs);
    }
}
