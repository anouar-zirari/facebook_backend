package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Invitation;
import com.anouarDev.facebookApp.model.Status;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.service.InvitationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvitationRepositoryTest {

    @Autowired
    private InvitationService invitationService;
    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void saveInvitationAndNotification() {
//        Users sender = this.userRepository.findById(1L).get();
//        Users receiver = this.userRepository.findById(2L).get();
//
//        this.invitationService.saveInvitationAndNotification(sender, receiver);
//    }

    @Test
    public void invitationResponse() {
        this.invitationService.InvitationResponse(4L, 1L, false);
    }

}