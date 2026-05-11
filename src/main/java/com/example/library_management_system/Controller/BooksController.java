package com.example.library_management_system.Controller;

import com.example.library_management_system.DTO.BookDTO;
import com.example.library_management_system.Models.Book;
import com.example.library_management_system.Services.BookServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class BooksController {

    private final BookServices bookServices;

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
        return bookServices.createBook(book);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookServices.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return bookServices.getBookById(id);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id , @RequestBody Book book) {
        return bookServices.updateBook(id , book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<BookDTO>  deleteBook(@PathVariable int id) {
        return bookServices.deleteBook(id);
    }
}
