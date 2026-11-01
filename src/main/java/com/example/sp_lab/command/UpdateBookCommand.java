package com.example.sp_lab.command;

import com.example.sp_lab.Book;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateBookCommand implements Command<Book>{

    private final Long id;

    private final Book book;

    private final CommandContext context;


    @Override
    public Book execute() {
        var repo = context.getBookRepository();
        if(!repo.existsById(id))
            return null;
        book.setId(id);
        return repo.save(book);
    }
}
