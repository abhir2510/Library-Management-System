package com.example.library_management_system.Services;

import com.example.library_management_system.Models.Book;
import com.example.library_management_system.Repositories.BooksRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServices {

    private final BooksRepository booksRepository;

    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        //return ResponseEntity.ok().body(booksRepository.save(book));
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(book));
    }

    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksRepository.findAll());
    }

    public ResponseEntity<Optional<Book>> getBookById(int bookId) {
        return ResponseEntity.ok(booksRepository.findById(bookId));
    }

    public ResponseEntity<Book> updateBook(int id , Book book) {
        return ResponseEntity.ok(booksRepository.save(book));
    }

    public ResponseEntity<Book> deleteBook(int id) {
        booksRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }
}
