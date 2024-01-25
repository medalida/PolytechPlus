package com.server.cinemaepul.director;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "director")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
}