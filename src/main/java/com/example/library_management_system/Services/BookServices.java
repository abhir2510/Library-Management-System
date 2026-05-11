package com.example.library_management_system.Services;

import com.example.library_management_system.DTO.BookDTO;
import com.example.library_management_system.Exception.BookExceptions.BookNotFoundException;
import com.example.library_management_system.Models.Book;
import com.example.library_management_system.Repositories.BooksRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServices {

    private final BooksRepository booksRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookServices.class);

    public ResponseEntity<Book> createBook(Book book) {
        logger.info("creating book {} inside {}", book , getClass());
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(book));
    }

    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksRepository.findAll());
    }

    public ResponseEntity<Book> getBookById(int bookId) {
        logger.info("Getting book {} inside {} getBookById method", bookId , getClass());
        Optional<Book> book = booksRepository.findById(bookId);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }

        throw new BookNotFoundException();
    }

    public ResponseEntity<BookDTO> updateBook(int id , Book book) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            book.setBookId(id);
            booksRepository.save(book);
            return ResponseEntity.ok(new BookDTO(book.getBookId() , book.getBookName()));
        }

        throw new BookNotFoundException();
    }

    public ResponseEntity<BookDTO> deleteBook(int id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            booksRepository.deleteById(id);
            return ResponseEntity.ok(new BookDTO(optionalBook.get().getBookId() , optionalBook.get().getBookName()));
        }

        throw new BookNotFoundException();
    }
}
