package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Comment;
import com.anouarDev.facebookApp.model.Likes;
import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.CommentRepository;
import com.anouarDev.facebookApp.repository.LikeRepository;
import com.anouarDev.facebookApp.repository.PostRepository;
import com.anouarDev.facebookApp.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Algorithm algorithm;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final ObjectMapper objectMapper;
    private final ImageService imageService;


    public void savePost(String postData, MultipartFile file) throws IOException {
        Post post = objectMapper.readValue(postData, Post.class);
        Users user = this.userRepository.findById(post.getUser().getId()).get();
        post.setUser(user);
        post.setDate(new Date());
        Post savedPost = this.postRepository.save(post);
        this.imageService.uploadImageToFileSystem(file, savedPost);
    }

    public List<Post> FindPostsByUser(Users user) {
        return this.postRepository.findPostByUser(user);
    }

    public List<Post> community(Users users) {
        List<Post> posts = new ArrayList<>();
        Optional<Users> user = this.userRepository.findById(users.getId());
        List<Users> friends = user.get().getFriends();
        friends.forEach(
                friend -> {
                    friend.getPosts().forEach(post -> {
                        posts.add(post);
                    });
                }
        );
        user.get().getPosts().forEach(post -> {
            posts.add(post);
        });
        algorithm.bubbleSortDescendingPosts(posts);
        return posts;
    }

    public Post savePostOptions(Long userId, Long postId, String comment, Long like) {
        Post post = this.postRepository.findById(postId).get();
        Users user = this.userRepository.findById(userId).get();
        if (post != null) {
            if (comment != null && like == 0L) {
                Comment newComment = Comment.builder()
                        .comment(comment)
                        .post(post)
                        .user(user)
                        .build();

                this.commentRepository.save(newComment);
            } else {
                Likes likes = this.likeRepository.findByPostAndUser(post, user);
                if (likes == null){
                        likes = Likes.builder()
                                .likes(1L)
                                .post(post)
                                .user(user)
                                .build();
                }
                else {
                    if (likes.getLikes() == 1)
                        likes.setLikes(likes.getLikes() - 1);
                    else likes.setLikes(likes.getLikes() + 1);
                }
                this.likeRepository.save(likes);
            }
        }
        return post;
    }
}
