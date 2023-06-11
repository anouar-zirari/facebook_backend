package com.anouarDev.facebookApp.controller;

import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public void savePost(@RequestBody Post post) {
        this.postService.savePost(post);
    }

    @PostMapping("/find-user-posts")
    public List<Post> findAll(@RequestBody Users user) {
        return this.postService.FindPostsByUser(user);
    }

    @PostMapping("/community")
    public List<Post> community(@RequestBody Users users) {
        return this.postService.community(users);
    }


}
