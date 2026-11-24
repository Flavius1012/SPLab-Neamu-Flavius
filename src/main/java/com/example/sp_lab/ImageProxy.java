package com.example.sp_lab;

import com.example.sp_lab.visitor_pattern.Visitor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class ImageProxy extends BaseElement{
    private String url;
    private String name;

    @Transient
    @JsonIgnore
    private Image realImage;

    public ImageProxy(String name) {
        this(name, name);
    }

    public ImageProxy(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url, name);
        }
        return realImage;
    }

//    @Override
//    public void print() {
//        loadImage().print();
//    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void add(Element e) { throw new UnsupportedOperationException("ImageProxy is a leaf"); }
    public void remove(Element e) { throw new UnsupportedOperationException("ImageProxy is a leaf"); }
    public Element get(int index) { throw new UnsupportedOperationException("ImageProxy is a leaf"); }
}


