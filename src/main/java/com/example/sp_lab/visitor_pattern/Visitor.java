package com.example.sp_lab.visitor_pattern;

import com.example.sp_lab.*;

public interface Visitor {
    void visit(Book book);
    void visit(Section section);
    void visit(TableOfContents tableOfContents);
    void visit(Paragraph paragraph);
    void visit(Image image);
    void visit(Table table);
}
