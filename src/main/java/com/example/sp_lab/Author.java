package com.example.sp_lab;

public class Author{
    private String name;
    private String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String print(){
        return "Author: " + name + surname;
    }
}
