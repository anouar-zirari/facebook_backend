package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostByUser(Users user);

    @Query("""
            SELECT image.post.id FROM Image image JOIN Post post WHERE post.user.id = :userId AND 
            post.id = image.post.id
            """)
    List<Long> postsWithImageIds(@Param("userId") Long userId);

    @Query(value = "SELECT friends_id FROM friends WHERE users_id = ?1",nativeQuery = true)
    List<Long> userFriendsId(Long userId);

}
