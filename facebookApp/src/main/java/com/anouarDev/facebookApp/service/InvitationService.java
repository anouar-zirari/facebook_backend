package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.model.Invitation;
import com.anouarDev.facebookApp.model.Notification;
import com.anouarDev.facebookApp.model.Status;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.InvitationRepository;
import com.anouarDev.facebookApp.repository.NotificationRepository;
import com.anouarDev.facebookApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveInvitationAndNotification(Users sender, Users receiver) {
        Invitation invitation = Invitation.builder()
                .sender(sender)
                .receiver(receiver)
                .status(Status.WAITING)
                .build();
        this.invitationRepository.save(invitation);

        Notification notification = Notification.builder()
                .senderId(sender.getId())
                .receiverId(receiver.getId())
                .userFirstName(sender.getFirstName())
                .userLastName(sender.getLastName())
                .build();
        this.notificationRepository.save(notification);
    }

    @Transactional
    public void InvitationResponse(Invitation invitation){
        if (invitation.getStatus().equals(Status.ACCEPT)){

            this.invitationRepository.save(invitation);

            Users receiver = this.userRepository.findById(invitation.getSender().getId()).get();
            Users sender = this.userRepository.findById(invitation.getReceiver().getId()).get();
            receiver.addFriends(sender);
            sender.addFriends(receiver);

            this.userRepository.save(receiver);
            this.userRepository.save(sender);

        }

    }
    
}
