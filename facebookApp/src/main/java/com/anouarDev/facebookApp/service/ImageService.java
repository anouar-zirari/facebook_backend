package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Image;
import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.repository.ImageRepository;
import com.anouarDev.facebookApp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final PostRepository postRepository;
    private final String   FOLDER_PATH = "E:\\workspace1\\facebookAppImages";

    public String uploadImageToFileSystem(MultipartFile file, Post post) throws IOException {
        String filePath = this.FOLDER_PATH + file.getOriginalFilename();


        Image fileData = imageRepository.save(
                Image.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filePath(filePath).post(post).build()
        );

        file.transferTo(new File(filePath));


        if (fileData != null)
            return "file uploaded successfully" + filePath;
        else
            return null;
    }

    public byte[] downloadImageFileSystem(Long postId) throws IOException {
        Optional<Image> fileData = imageRepository.findByPostId(postId);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

}
