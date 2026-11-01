package com.example.sp_lab.service;

import com.example.sp_lab.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Book> getAll(){
        return new ArrayList<>(books.values());
    }

    public Book getById(Long id){
        return books.get(id);
    }

    public Book create(Book book){
        Long newId = nextId.getAndIncrement();
        book.setId(newId);
        books.put(newId, book);
        return book;
    }

    public Book update(Long id, Book book){
        if(!books.containsKey(id))
            return null;
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public boolean delete(Long id){
        return books.remove(id) != null;
    }
}
