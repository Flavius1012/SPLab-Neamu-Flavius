package com.example.sp_lab.command;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component("asyncExecutor")
public class AsyncCommandExecutor implements CommandExecutor {

    private final ExecutorService pool = Executors.newFixedThreadPool(4);
    private final Map<String, CompletableFuture<?>> requests = new ConcurrentHashMap<>();

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        return CompletableFuture.supplyAsync(command::execute, pool);
    }

    public String submit(Command<?> command) {
        String id = UUID.randomUUID().toString();
        requests.put(id, execute(command));
        return id;
    }

    public CompletableFuture<?> getRequest(String id) {
        return requests.get(id);
    }

    @PreDestroy
    public void shutdown() {
        pool.shutdown();
    }
}