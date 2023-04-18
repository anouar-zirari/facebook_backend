package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Gender;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {


    @Autowired
    private UsersService userService;

    @Test
    public void save() {
        Users user1 = Users.builder()
                .firstName("mohamed")
                .lastName("hammadi")
                .email("mohamed@gmail.com")
                .password("123")
                .gender(Gender.MALE)
                .build();
        this.userService.saveUser(user1);

        Users user2 = Users.builder()
                .firstName("ikram")
                .lastName("elkarma")
                .email("elkarma@gmail.com")
                .password("123")
                .gender(Gender.FEMALE)
                .build();
        this.userService.saveUser(user2);

        Users user3 = Users.builder()
                .firstName("daoud")
                .lastName("moad")
                .email("doudmoad@gmail.com")
                .password("123")
                .gender(Gender.MALE)
                .build();
        this.userService.saveUser(user3);

        Users user4 = Users.builder()
                .firstName("hakim")
                .lastName("moad")
                .email("hakim@gmail.com")
                .password("123")
                .gender(Gender.MALE)
                .build();
        this.userService.saveUser(user4);


    }

}