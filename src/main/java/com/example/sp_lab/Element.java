package com.example.sp_lab;

import com.example.sp_lab.visitor_pattern.Visitor;

public interface Element {
    void print();
    void add(Element e);
    void remove(Element e);
    Element get(int index);
    void accept(Visitor visitor);
}
