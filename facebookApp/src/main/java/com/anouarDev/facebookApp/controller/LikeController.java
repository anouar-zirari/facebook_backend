package com.anouarDev.facebookApp.controller;

import com.anouarDev.facebookApp.dto.LikeDto;
import com.anouarDev.facebookApp.model.Likes;
import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/like")
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/find-likes-for-user/{postId}")
    public LikeDto findLikeByPostAndUser(@PathVariable("postId") Long postId) {
        Post post = Post.builder().id(postId).build();

        return this.likeService.findLikesByPost(post);
    }

}
