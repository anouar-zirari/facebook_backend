package com.anouarDev.facebookApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private String content;
    private Long likes;
    private Date date;
    @ManyToOne
    private Users user;


}
