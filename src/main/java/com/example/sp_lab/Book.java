package com.example.sp_lab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book{

    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private List<Element> elements = new ArrayList<>();

    @ManyToMany
    private List<Author> authors = new ArrayList<>();
    public Book(String title){
        this.title = title;
    }

    public void print() {
        for(Element e : elements)
            e.print();
    }

    public void addContent(Element e) {
        elements.add(e);
    }

    public void remove(Element e) {
        elements.remove(e);
    }

    public Element get(int index) {
        return elements.get(index);
    }

    public void addAuthor(Author a){
        authors.add(a);
    }
}
