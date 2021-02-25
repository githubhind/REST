package com.test.rest.rest.dao;

import com.test.rest.rest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
