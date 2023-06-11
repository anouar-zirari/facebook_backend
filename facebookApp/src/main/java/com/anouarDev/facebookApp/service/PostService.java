package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.PostRepository;
import com.anouarDev.facebookApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Algorithm algorithm;


    public void savePost(Post post) {
        post.setDate(new Date());
        this.postRepository.save(post);
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
        algorithm.bubbleSortDescending(posts);
        return posts;
    }

}
