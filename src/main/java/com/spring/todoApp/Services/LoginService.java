package com.spring.todoApp.Services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validate(String userid, String password) {
        return "test".equalsIgnoreCase(userid) && "password".equalsIgnoreCase(password);
    }

}
