package com.example.library_management_system.Services;

import com.example.library_management_system.Models.Book;
import com.example.library_management_system.Repositories.BooksRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServices {

    private final BooksRepository booksRepository;

    public ResponseEntity<Book> createBook(Book book) {
        //return ResponseEntity.ok().body(booksRepository.save(book));
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(book));
    }

    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksRepository.findAll());
    }

    public ResponseEntity<Book> getBookById(int bookId) {
        Optional<Book> book = booksRepository.findById(bookId);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Book> updateBook(int id , Book book) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            book.setBookId(id);
            booksRepository.save(book);
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Book> deleteBook(int id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            booksRepository.deleteById(id);
            return ResponseEntity.ok(optionalBook.get());
        }

        return ResponseEntity.notFound().build();
    }
}
