package com.example.sp_lab.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    @GetMapping("/books")
    public String returnBooks(){
        return "Returns all the books";
    }

    @GetMapping("/books/{id}")
    public String returnDetailsBook(@PathVariable int id){
        return "Returns details of book with id: " + id;
    }

    @PostMapping("/books")
    public String createBook(){
        return "Create a book";
    }

    @PutMapping("/books/{id}")
    public String replaceBook(@PathVariable int id){
        return "Replaces the representation of specified book";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){
        return "Deletes book with id " + id;
    }

}
