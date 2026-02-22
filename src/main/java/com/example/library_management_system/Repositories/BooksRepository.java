package com.example.library_management_system.Repositories;

import com.example.library_management_system.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Integer> {

}

