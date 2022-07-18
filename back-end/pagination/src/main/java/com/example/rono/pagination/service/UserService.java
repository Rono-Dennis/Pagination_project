package com.example.rono.pagination.service;

import com.example.rono.pagination.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUser(String name, int page, int size);
}
