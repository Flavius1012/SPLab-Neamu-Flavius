package com.example.sp_lab.command;

import com.example.sp_lab.Book;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteBookCommand implements Command<Boolean>{

    private final Long id;

    private final CommandContext context;


    @Override
    public Boolean execute() {
        var repo = context.getBookRepository();
        if(!repo.existsById(id))
            return false;
        repo.deleteById(id);
        return true;
    }
}
