package com.server.cinemaepul.utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "username", nullable = false, length = 30)
    private String username;


    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Transient
    @JsonIgnore
    private String role = "User";
}
