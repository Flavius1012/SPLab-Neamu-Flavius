package com.example.sp_lab;

import com.example.sp_lab.visitor_pattern.Visitor;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Image extends BaseElement{

    private String url;

    private String name;

    public Image(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void print() { System.out.println("Image with name:" + name); }

    public void add(Element e) { throw new UnsupportedOperationException("Image is a leaf"); }
    public void remove(Element e) { throw new UnsupportedOperationException("Image is a leaf"); }
    public Element get(int index) { throw new UnsupportedOperationException("Image is a leaf"); }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
