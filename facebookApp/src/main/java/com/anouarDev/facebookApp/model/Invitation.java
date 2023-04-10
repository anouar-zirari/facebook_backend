package com.anouarDev.facebookApp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invitation {
    @Id
    @SequenceGenerator(
            name = "invitation_sequence",
            sequenceName = "invitation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invitation_sequence"
    )
    private Long id;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Users receiverId;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Users senderId;
}
