package com.server.cinemaepul.actor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.cinemaepul.charcter.Character;
import com.server.cinemaepul.types.Gender;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "deathday")
    private LocalDate death_day;

    @Column(name = "place_of_birth", length = 20)
    private String place_of_birth;

    @Column(name = "profile_path")
    private String profile_path;

    @Column(name = "biography")
    private String biography;

    @Column(name = "popularity", nullable = false)
    private double popularity;

    @OneToMany(mappedBy = "actor")
    @JsonIgnore
    private Set<Character> personnages = new LinkedHashSet<>();
}