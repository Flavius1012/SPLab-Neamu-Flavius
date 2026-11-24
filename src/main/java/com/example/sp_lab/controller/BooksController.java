package com.example.sp_lab.controller;

import com.example.sp_lab.Book;
import com.example.sp_lab.command.*;
import com.example.sp_lab.observer_pattern.AllBooksSubject;
import com.example.sp_lab.persistence.CrudRepository;
import com.example.sp_lab.repository.BookRepository;
import com.example.sp_lab.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class BooksController {

    private final CommandContext context;
    private final AllBooksSubject allBooksSubject;
    private final CommandExecutor syncExecutor;
    private final CommandExecutor asyncExecutor;

    public BooksController(CrudRepository<Book, Long> bookRepository, AllBooksSubject allBooksSubject,
                            @Qualifier("syncExecutor") CommandExecutor syncExecutor,
                            @Qualifier("asyncExecutor") CommandExecutor asyncExecutor){
        this.context = new CommandContext(bookRepository);
        this.allBooksSubject = allBooksSubject;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
    }

    @GetMapping("/books")
    public List<Book> returnBooks(){
        return syncExecutor.execute(new GetAllBooksCommand(context)).join();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> returnDetailsBook(@PathVariable Long id) {
        Book book = syncExecutor.execute(new GetBookByIdCommand(id, context)).join();
        if (book == null)
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
