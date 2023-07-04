package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Comment;
import com.anouarDev.facebookApp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findCommentByPostId(Long postId) {
        return this.commentRepository.findCommentByPostId(postId);
    }

}
