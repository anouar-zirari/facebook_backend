package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Algorithm {
    public void bubbleSortDescendingPosts(List<Post> posts) {
        int n = posts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (posts.get(j).getDate().compareTo(posts.get(j + 1).getDate()) < 0) {
                    // Swap elements
                    Post temp = posts.get(j);
                    posts.set(j, posts.get(j + 1));
                    posts.set(j + 1, temp);
                }
            }
        }
    }

}
