package com.example.sp_lab.repository;

import com.example.sp_lab.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
