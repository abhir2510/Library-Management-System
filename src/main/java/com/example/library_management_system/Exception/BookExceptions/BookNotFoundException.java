package com.example.library_management_system.Exception.BookExceptions;

import com.example.library_management_system.Exception.Enums.BookErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException() {
        super(BookErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
