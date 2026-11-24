package com.example.sp_lab.command;

import java.util.concurrent.CompletableFuture;

public interface CommandExecutor {
    <T> CompletableFuture<T> execute(Command<T> command);
}