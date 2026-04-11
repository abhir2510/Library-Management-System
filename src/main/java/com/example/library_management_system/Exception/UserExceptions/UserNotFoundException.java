package com.example.library_management_system.Exception.UserExceptions;

import com.example.library_management_system.Exception.Enums.UserErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super(UserErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
