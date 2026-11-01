package com.example.sp_lab.command;

import com.example.sp_lab.Book;
import com.example.sp_lab.persistence.CrudRepository;
import com.example.sp_lab.repository.BookRepository;
import com.example.sp_lab.service.BookService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommandContext {
    private final CrudRepository<Book, Long> bookRepository;
}
