package com.example.freetalk.oauth2.dto;


import com.example.freetalk.oauth2.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SessionUserDto implements Serializable {
    private String email;
    private Long id;

    public SessionUserDto(User user) {
        this.email = user.getEmail();
        this.id = user.getId();
    }
}