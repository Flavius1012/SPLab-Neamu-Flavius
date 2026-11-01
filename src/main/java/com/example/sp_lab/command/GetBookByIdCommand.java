package com.example.sp_lab.command;

import com.example.sp_lab.Book;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetBookByIdCommand implements Command<Book>{

    private final Long id;

    private final CommandContext context;


    @Override
    public Book execute() {
        return context.getBookRepository().findById(id).orElse(null);
    }
}
