package com.example.sp_lab.command;

import com.example.sp_lab.Book;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBookCommand implements Command<Book>{

    private final Book book;

    private final CommandContext context;


    @Override
    public Book execute() {
        return context.getBookRepository().save(book);
    }
}

