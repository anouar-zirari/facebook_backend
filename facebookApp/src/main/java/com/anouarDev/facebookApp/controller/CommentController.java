package com.anouarDev.facebookApp.controller;

import com.anouarDev.facebookApp.model.Comment;
import com.anouarDev.facebookApp.service.CommentService;
import com.anouarDev.facebookApp.service.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;
    private final PostService postservice;

    @GetMapping("/comments-by-post/{postId}")
    public List<Comment> getCommentByPost(@PathVariable("postId") Long postId) {
        return this.commentService.findCommentByPostId(postId);
    }

    @PostMapping("/save-post-options")
    public void savePostOptions(
            @RequestParam("userId") Long userId,
            @RequestParam("postId") Long postId,
            @RequestParam("comment") String comment,
            @RequestParam("like") Long like
            ) {
        this.postservice.savePostOptions(userId, postId, comment, like);
    }
}
