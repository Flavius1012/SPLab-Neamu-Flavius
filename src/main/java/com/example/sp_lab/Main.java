package com.example.sp_lab;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Carte 1");
        Author author1 = new Author("John", "Jones");
        book1.addAuthor(author1);

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Capitolul 1.1.1.1");

        book1.addContent(new Paragraph("BEFORE"));
        book1.addContent(cap1);
        cap1.add(new Paragraph("Inceput capitol 1"));
        Paragraph p1 = new Paragraph("Text cu aliniere la stanga");
        p1.setAlignStrategy(new AlignLeft());
        Paragraph p2 = new Paragraph("Text cu aliniere la dreapta");
        p2.setAlignStrategy(new AlignRight());
        cap1.add(p1);
        cap1.add(p2);
        cap1.add(cap11);

        cap11.add(new Paragraph("Inceput subcapitol 1.1"));
        cap11.add(cap111);

        cap111.add(new Paragraph("Inceput subcapitol 1.1.1"));
        cap111.add(cap1111);

        cap1111.add(new Paragraph("Inceput subcapitol 1.1.1.1"));
        cap1111.add(new Image("url", "Imagine subcapitol 1.1.1.1"));

        book1.print();





    }
}
