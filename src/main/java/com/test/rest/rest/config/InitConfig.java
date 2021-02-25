package com.test.rest.rest.config;

import com.test.rest.rest.dao.UserDao;
import com.test.rest.rest.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {

    @Bean
    public CommandLineRunner initUsers(UserDao userDao){
        return (args) -> {
            userDao.save(new User("Jan", "szambonurek"));
            userDao.save(new User("Sebastian", "rzeźnik"));
        };
    }
}
