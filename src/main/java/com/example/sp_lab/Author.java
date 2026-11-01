package com.example.sp_lab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Author{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String print(){
        return "Author: " + name + " " +  surname;
    }

}
