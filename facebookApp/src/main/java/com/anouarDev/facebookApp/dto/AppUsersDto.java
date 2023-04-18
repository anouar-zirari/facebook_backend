package com.anouarDev.facebookApp.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * this class is for friends suggestion page
 *
 * */

@JsonFormat
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUsersDto {
    private Long id;
    private String firstName;
    private String lastName;
}
