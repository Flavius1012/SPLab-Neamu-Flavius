package com.example.sp_lab;

public class Paragraph implements Element {

    private String text;

    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
        textAlignment = null;
    }

    public void print() {
        if(textAlignment == null)
            System.out.println("Paragraph: " + text);
        else
            textAlignment.render(this, new Context(50));
    }

    public void add(Element e) { throw new UnsupportedOperationException("Paragraph is a leaf"); }
    public void remove(Element e) { throw new UnsupportedOperationException("Paragraph is a leaf"); }
    public Element get(int index) { throw new UnsupportedOperationException("Paragraph is a leaf"); }

    public void setAlignStrategy(AlignStrategy alignment){
        this.textAlignment = alignment;
    }

    public String getText(){ return text;}
}