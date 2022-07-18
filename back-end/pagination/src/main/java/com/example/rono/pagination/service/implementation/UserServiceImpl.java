package com.example.rono.pagination.service.implementation;

import com.example.rono.pagination.domain.User;
import com.example.rono.pagination.repository.UserRepository;
import com.example.rono.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<User> getUser(String name, int page, int size) {
        log.info("Fetching users for page {} of size", page, size);
        return userRepository. findByNameContains(name, of(page, size));
    }
}
