package com.example.sp_lab.controller;

import com.example.sp_lab.Book;
import com.example.sp_lab.command.*;
import com.example.sp_lab.observer_pattern.AllBooksSubject;
import com.example.sp_lab.persistence.CrudRepository;
import com.example.sp_lab.repository.BookRepository;
import com.example.sp_lab.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class BooksController {

    private final CommandContext context;
    private final AllBooksSubject allBooksSubject;

    public BooksController(CrudRepository<Book, Long> bookRepository, AllBooksSubject allBooksSubject){
        this.context = new CommandContext(bookRepository);
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books")
    public List<Book> returnBooks(){
        return new GetAllBooksCommand(context).execute();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> returnDetailsBook(@PathVariable Long id){
        Book book = new GetBookByIdCommand(id, context).execute();
        if(book == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){

       Book saved = new CreateBookCommand(book, context).execute();
       allBooksSubject.add(saved);
       return saved;
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> replaceBook(@PathVariable Long id, @RequestBody Book book){

        Book updated = new UpdateBookCommand(id, book, context).execute();

        if(updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){

        Boolean deleted = new DeleteBookCommand(id, context).execute();

        if(!deleted)
            return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }

}
