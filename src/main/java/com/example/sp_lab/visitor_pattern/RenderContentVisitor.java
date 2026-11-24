package com.example.sp_lab.visitor_pattern;

import com.example.sp_lab.*;

public class RenderContentVisitor implements Visitor{

    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println();
        System.out.println("Authors:");
        book.getAuthors().forEach(a -> System.out.println(a.print()));
        System.out.println();
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle() + ':');
      //  section.getElements().forEach(e -> e.accept(this));
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        System.out.println("TABLE OF CONTENTS:");

    }

    @Override
    public void visit(Paragraph paragraph) {
        if(paragraph.getTextAlignment() == null)
            System.out.println("Paragraph: " + paragraph.getText());
        else
            paragraph.getTextAlignment().render(paragraph, new Context(50));
    }

    @Override
    public void visit(Image image) {
        System.out.println("Image with name:" + image.getName());
    }

    @Override
    public void visit(Table table) {
        System.out.println("Table with title:" + table.getTitle());
    }


    @Override
    public void visit(ImageProxy imageProxy) {
        Image image = imageProxy.loadImage();
        System.out.println("Image with name:" + image.getName());
    }

}
