package com.test.rest.rest.service;

import com.test.rest.rest.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> getById(Long id);

    User save(User user);

    void deleteById(Long id);
}
