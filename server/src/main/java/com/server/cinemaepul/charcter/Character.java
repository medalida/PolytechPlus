package com.server.cinemaepul.charcter;

import com.server.cinemaepul.actor.Actor;
import com.server.cinemaepul.movie.Movie;
import com.server.cinemaepul.types.Gender;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "character")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "order", nullable = false)
    private int order;

    @Column(name = "profile_path", nullable = false)
    private String profile_path;

    @Column(name = "actor_id")
    private Integer actor;

    @Column(name = "movie_id")
    private int movie;
}