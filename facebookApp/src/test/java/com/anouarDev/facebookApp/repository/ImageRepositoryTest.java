package com.anouarDev.facebookApp.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class ImageRepositoryTest {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void findImageByUser() {
        System.out.println(imageRepository.findImagesByUserId(1L));
    }

}