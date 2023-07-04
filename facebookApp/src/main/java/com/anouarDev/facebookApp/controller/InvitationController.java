package com.anouarDev.facebookApp.controller;

import com.anouarDev.facebookApp.model.Invitation;
import com.anouarDev.facebookApp.model.Notification;
import com.anouarDev.facebookApp.service.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/invitation")
public class InvitationController {

    private final InvitationService invitationService;

    @PostMapping
    public void invitation(@RequestBody Invitation invitation) {
        this.invitationService.saveInvitationAndNotification(invitation);
    }

    @PostMapping("/friendshipResponse")
    public void friendshipResponse(@RequestParam("senderId") Long senderId,
                                   @RequestParam("receiverId") Long receiverId,
                                   @RequestParam("response") boolean response) {
        this.invitationService.InvitationResponse(senderId, receiverId, response);
    }

    @GetMapping("/find-inv-by-sender/{senderId}")
    public List<Invitation> findInvitationBySender(@PathVariable("senderId") Long senderId) {
        return this.invitationService.findInvitationBySender(senderId);
    }

    @GetMapping("/find-inv-by-receiver/{receiverId}")
    public List<Invitation> findInvitationByReceiver(@PathVariable("receiverId") Long receiverId) {
        return this.invitationService.findInvitationByReceiver(receiverId);
    }

    @PostMapping("/find-inv-by-sender-receiver")
    public Invitation findInvitationBySenderAndReceiver(
            @RequestParam("senderId") Long senderId,
            @RequestParam("receiverId") Long receiverId) {
        return this.invitationService.findInvitationBySenderAndReceiver(senderId, receiverId);
    }


}
