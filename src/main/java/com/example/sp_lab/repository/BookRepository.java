package com.example.sp_lab.repository;

import com.example.sp_lab.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
