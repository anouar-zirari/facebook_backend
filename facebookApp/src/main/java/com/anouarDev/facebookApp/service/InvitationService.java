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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveInvitationAndNotification(Invitation invitation) {
        invitation.setStatus(Status.WAITING);
        this.invitationRepository.save(invitation);

        Notification notification = Notification.builder()
                .senderId(invitation.getSender().getId())
                .receiverId(invitation.getReceiver().getId())
                .senderFirstName(invitation.getSender().getFirstName())
                .senderLastName(invitation.getSender().getLastName())
                .receiverFirstName(invitation.getReceiver().getFirstName())
                .receiverLastName(invitation.getReceiver().getLastName())
                .date(new Date())
                .build();
        this.notificationRepository.save(notification);
    }

    @Transactional
    public void InvitationResponse(Long senderId, Long receiverId, boolean response){
        Invitation invitation = this.invitationRepository.findBySenderIdAndReceiverId(senderId, receiverId);
        if (response == true){
            invitation.setStatus(Status.ACCEPT);
            this.invitationRepository.save(invitation);

            Users receiver = this.userRepository.findById(invitation.getSender().getId()).get();
            Users sender = this.userRepository.findById(invitation.getReceiver().getId()).get();
            receiver.addFriends(sender);
            sender.addFriends(receiver);

            this.userRepository.save(receiver);
            this.userRepository.save(sender);

        } else {
            invitation.setStatus(Status.REFUSE);
            this.invitationRepository.save(invitation);
        }
    }
    
}
