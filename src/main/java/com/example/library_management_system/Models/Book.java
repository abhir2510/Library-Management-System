package com.example.library_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    int bookId;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "bookAuthor")
    private String bookAuthor;
}
