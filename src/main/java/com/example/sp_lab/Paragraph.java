package com.example.sp_lab;

import com.example.sp_lab.strategy_pattern.AlignStrategy;
import com.example.sp_lab.visitor_pattern.Visitor;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Paragraph extends BaseElement {

    private String text;

    @Transient
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setAlignStrategy(AlignStrategy alignment){
        this.textAlignment = alignment;
    }

    public String getText(){ return text;}

    public AlignStrategy getTextAlignment() {
        return textAlignment;
    }
}