package com.example.sp_lab;

import com.example.sp_lab.visitor_pattern.Visitor;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@jakarta.persistence.Table(name = "TableElement")
public class Table extends BaseElement {
    private String title;

    public Table(String title) { this.title = title; }

    public void print() { System.out.println("Table with title:" + title); }

    public void add(Element e) { throw new UnsupportedOperationException("Table is a leaf"); }
    public void remove(Element e) { throw new UnsupportedOperationException("Table is a leaf"); }
    public Element get(int index) { throw new UnsupportedOperationException("Table is a leaf"); }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}