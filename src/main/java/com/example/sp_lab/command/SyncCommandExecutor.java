package com.example.sp_lab.command;

import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;

@Component("syncExecutor")
public class SyncCommandExecutor implements CommandExecutor {

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        return CompletableFuture.completedFuture(command.execute());
    }
}