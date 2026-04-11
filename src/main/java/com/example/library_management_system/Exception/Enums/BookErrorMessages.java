package com.example.library_management_system.Exception.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BookErrorMessages {
    PRODUCT_NOT_FOUND("Book not found");

    private final String message;

}
