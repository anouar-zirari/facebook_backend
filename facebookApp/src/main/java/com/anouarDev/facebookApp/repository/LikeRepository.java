package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Likes;
import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    Likes findByPostAndUser(Post post, Users user);
    List<Likes> findByPost(Post post);

//    @Query("SELECT SUM(l.likes = 1) AS COUNT, l.post.id FROM Likes l WHERE l.post = :post GROUP BY l.id")
//    List<Object[]> findLikesForPost(Post post);

    @Query("SELECT l FROM Likes l WHERE l.post =:post")
    List<Likes> findLikesForPost(Post post);
}
