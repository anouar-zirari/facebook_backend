package com.anouarDev.facebookApp.controller;

import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public void savePost(
            @RequestParam("post") String post,
            @RequestParam("file")MultipartFile file
    ) throws IOException {
        this.postService.savePost(post, file);
    }

    @PostMapping("/find-user-posts")
    public List<Post> findAll(@RequestBody Users user) {
        return this.postService.FindPostsByUser(user);
    }

    @PostMapping("/community")
    public List<Post> community(@RequestBody Users users) {
        return this.postService.community(users);
    }

    //comment or like
    @PostMapping("/post-options")
    public Post savePostOption(
            @RequestParam("userId") Long userId,
            @RequestParam("postId") Long postId,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam("like") Long like) {
        return this.postService.savePostOptions(userId ,postId, comment, like);
    }


}
