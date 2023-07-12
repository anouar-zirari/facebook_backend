package com.anouarDev.facebookApp.controller;


import com.anouarDev.facebookApp.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/image")
public class ImageController {
    private final ImageService imageService;

//    @PostMapping
//    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
//         String uploadImage = this.imageService.uploadImageToFileSystem(file);
//         return ResponseEntity.status(HttpStatus.OK)
//                 .body(uploadImage);
//    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> downloadImage(@PathVariable("postId") Long postId) throws IOException {
        byte[] imageData =  this.imageService.downloadImageFileSystem(postId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

}
