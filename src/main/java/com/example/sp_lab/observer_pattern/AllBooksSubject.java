package com.example.sp_lab.observer_pattern;

import com.example.sp_lab.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject{

    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for(Observer o : observers)
            o.update(book);
    }

    public void add(Book book){
        notifyObservers(book);
    }
}
