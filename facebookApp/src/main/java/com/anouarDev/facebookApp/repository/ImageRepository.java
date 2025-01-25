package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Image;
import com.anouarDev.facebookApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByName(String fileName);
    Optional<Image> findByPostId(Long postId);


    @Query("SELECT image FROM Image image JOIN Post post WHERE " +
            "post.id = image.post.id AND post.user.id =:userId")
    List<Image> findImagesByUserId(@Param("userId") Long userId);

     

}
