package com.example.sp_lab;

public class Image implements Element {

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
}
