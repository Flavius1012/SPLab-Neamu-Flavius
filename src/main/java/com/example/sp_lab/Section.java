package com.example.sp_lab;

import com.example.sp_lab.visitor_pattern.Visitor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Entity
public class Section extends BaseElement{

    private String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();

    public Section(String title){
        this.title = title;
    }


    @Override
    public void print() {
        System.out.println(title + ':');
        elements.forEach(Element::print);
    }

    @Override
    public void add(Element e) {
        elements.add(e);
    }

    @Override
    public void remove(Element e) {
        elements.remove(e);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        elements.forEach(e -> e.accept(visitor));
    }
}
