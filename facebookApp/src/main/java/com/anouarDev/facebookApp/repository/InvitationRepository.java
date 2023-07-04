package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Invitation;
import com.anouarDev.facebookApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    Invitation findBySenderIdAndReceiverId(Long senderId, Long receiverId);

    @Query("SELECT inv FROM Invitation inv WHERE inv.sender.id = :senderId")
    List<Invitation> findBySenderId(Long senderId);

    @Query("SELECT inv FROM Invitation inv WHERE inv.receiver.id = :receiverId")
    List<Invitation> findByReceiverId(Long receiverId);
}
