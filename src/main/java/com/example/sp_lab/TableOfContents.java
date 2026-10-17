package com.example.sp_lab;

import com.example.sp_lab.visitor_pattern.Visitor;

public class TableOfContents implements Element {

    public void print() { System.out.println("Table of contents"); }

    public void add(Element e) { throw new UnsupportedOperationException("TableOfContents is a leaf"); }
    public void remove(Element e) { throw new UnsupportedOperationException("TableOfContents is a leaf"); }
    public Element get(int index) { throw new UnsupportedOperationException("TableOfContents is a leaf"); }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}