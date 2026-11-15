package com.example.sp_lab.command;

import com.example.sp_lab.Book;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class GetAllBooksCommand implements Command<List<Book>>{

    private final CommandContext context;

    @Override
    public List<Book> execute() {
        return context.getBookRepository().findAll();
    }
}
