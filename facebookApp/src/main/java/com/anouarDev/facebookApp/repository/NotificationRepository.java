package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.receiverId = :userId or n.senderId = :userId")
    Optional<List<Notification>> friendshipNotificationForUser(@Param("userId") Long userId);
}
