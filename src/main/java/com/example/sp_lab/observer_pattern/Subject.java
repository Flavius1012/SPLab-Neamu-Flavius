package com.example.sp_lab.observer_pattern;

import com.example.sp_lab.Book;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}
