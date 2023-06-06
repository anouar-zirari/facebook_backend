package com.anouarDev.facebookApp.controller;


import com.anouarDev.facebookApp.model.Notification;
import com.anouarDev.facebookApp.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/find-all/{userId}")
    public List<Notification> getFriendShipNotificationForUser(
            @PathVariable("userId") Long id
    ) {
        return this.notificationService.getFriendShipNotificationForUser(id);
    }
}
