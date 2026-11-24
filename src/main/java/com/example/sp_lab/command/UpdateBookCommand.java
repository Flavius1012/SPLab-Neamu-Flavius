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
        return context.getBookRepository().findById(id)
                .map(existing -> {
                    existing.setTitle(book.getTitle());
                    existing.setAuthors(book.getAuthors());
                    return context.getBookRepository().save(existing);
                })
                .orElse(null);
    }
}
