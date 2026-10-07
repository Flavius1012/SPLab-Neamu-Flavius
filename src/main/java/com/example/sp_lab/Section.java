package com.example.sp_lab;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element{

    private String title;

    private final List<Element> elements;

    public Section(String title){
        this.title = title;

        elements = new ArrayList<>();
    }


    @Override
    public void print() {
        System.out.println("Sectiunea " + title + ':');

        elements.forEach(Element::print);
    }

    @Override
    public void add(Element e) {



    }

    @Override
    public void remove(Element e) {

    }

    @Override
    public Element get(int index) {
        return null;
    }
}
