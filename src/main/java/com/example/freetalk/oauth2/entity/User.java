package com.example.freetalk.oauth2.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="user")
@ToString
public class
User {
    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;


    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private Role role;

    @Builder
    public User(String email, Role role) {

        this.email = email;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }


}
