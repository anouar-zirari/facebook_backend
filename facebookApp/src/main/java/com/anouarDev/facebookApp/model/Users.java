package com.anouarDev.facebookApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "user",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_email",
                columnNames = "email_address"
        )
)
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    @Column(name = "email_address", nullable = false)
    private String email;
    private Gender gender;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "friends")
    private List<Users> friends;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    

    public void addFriends(Users user){
        if (friends == null) friends = new ArrayList<>();
        friends.add(user);
    }

}
