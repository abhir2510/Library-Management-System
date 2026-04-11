package com.example.library_management_system.Exception.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorMessages {
    USER_NOT_FOUND("User not Found");

    private final String message;
}
