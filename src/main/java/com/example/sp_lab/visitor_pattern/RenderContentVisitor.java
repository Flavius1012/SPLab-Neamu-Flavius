package com.example.sp_lab.visitor_pattern;

import com.example.sp_lab.*;

public class RenderContentVisitor implements Visitor{
    @Override
    public void visit(Book book) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle() + ':');
      //  section.getElements().forEach(e -> e.accept(this));
    }

    @Override
    public void visit(TableOfContents tableOfContents) {

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
}
