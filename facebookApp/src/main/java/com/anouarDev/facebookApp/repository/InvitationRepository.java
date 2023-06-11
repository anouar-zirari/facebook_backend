package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    Invitation findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
