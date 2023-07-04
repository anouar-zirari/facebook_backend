package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.dto.LikeDto;
import com.anouarDev.facebookApp.model.Likes;
import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.LikeRepository;
import jakarta.persistence.SecondaryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;


    public LikeDto findLikesByPost(Post post) {
        List<Likes> likes = this.likeRepository.findLikesForPost(post);
        Long numberOfLikesOfPost = 0L;
        for (Likes like : likes) {
            numberOfLikesOfPost += like.getLikes();
        }
        LikeDto likeDto = LikeDto.builder()
                .id(post.getId())
                .numberOfLikes(numberOfLikesOfPost)
                .build();

        return likeDto;
    }



}
