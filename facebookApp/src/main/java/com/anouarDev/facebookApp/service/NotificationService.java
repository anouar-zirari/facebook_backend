package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Notification;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> getFriendShipNotificationForUser(Long userId) {
        Optional<List<Notification>> notifications =
                this.notificationRepository.friendshipNotificationForUser(userId);
        return notifications.orElseThrow( () ->
                new IllegalStateException("user with id: " + userId + "not found"));
    }
}
