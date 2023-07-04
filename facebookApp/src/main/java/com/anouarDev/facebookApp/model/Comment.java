package com.anouarDev.facebookApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Users user;


}
