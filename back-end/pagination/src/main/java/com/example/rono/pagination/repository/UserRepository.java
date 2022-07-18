package com.example.rono.pagination.repository;

import com.example.rono.pagination.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findByNameContains(String name, Pageable pageable);
}
