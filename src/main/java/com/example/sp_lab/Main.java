package com.example.sp_lab;

import com.example.sp_lab.strategy_pattern.AlignLeft;
import com.example.sp_lab.strategy_pattern.AlignRight;
import com.example.sp_lab.visitor_pattern.BookStatistics;
import com.example.sp_lab.visitor_pattern.GenerateToC;
import com.example.sp_lab.visitor_pattern.RenderContentVisitor;

public class Main {
    public static void main(String[] args) {

//        Book book1 = new Book("Carte 1");
//        Author author1 = new Author("John", "Jones");
//        book1.addAuthor(author1);
//
//        Section cap1 = new Section("Capitolul 1");
//        Section cap11 = new Section("Capitolul 1.1");
//        Section cap111 = new Section("Capitolul 1.1.1");
//        Section cap1111 = new Section("Capitolul 1.1.1.1");
//
//        book1.addContent(new Paragraph("BEFORE"));
//        book1.addContent(cap1);
//        cap1.add(new Paragraph("Inceput capitol 1"));
//        Paragraph p1 = new Paragraph("Text cu aliniere la stanga");
//        p1.setAlignStrategy(new AlignLeft());
//        Paragraph p2 = new Paragraph("Text cu aliniere la dreapta");
//        p2.setAlignStrategy(new AlignRight());
//        cap1.add(p1);
//        cap1.add(p2);
//        cap1.add(cap11);
//
//        cap11.add(new Paragraph("Inceput subcapitol 1.1"));
//        cap11.add(cap111);
//
//        cap111.add(new Paragraph("Inceput subcapitol 1.1.1"));
//        cap111.add(cap1111);
//
//        cap1111.add(new Paragraph("Inceput subcapitol 1.1.1.1"));
//        cap1111.add(new Image("url", "Imagine subcapitol 1.1.1.1"));
//
//        book1.print();


        Book book1 = new Book("BOOK");


        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
       // cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("url", "Image1"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));


        Section cap2 = new Section("Capitolul 2");
        Section cap3 = new Section("Capitolul 3");




        book1.addContent(cap1);
        book1.addContent(cap2);
        book1.addContent(cap3);
//        BookStatistics stats = new BookStatistics();
//        cap1.accept(stats);
//        stats.printStatistics();

//        System.out.println();
//        System.out.println();
//
//        RenderContentVisitor afisare = new RenderContentVisitor();
//        cap1.accept(afisare);
//
//        System.out.println();
//        System.out.println();

        GenerateToC ToC = new GenerateToC();
        ToC.visit(book1);
        ToC.printToC();

    }
}
