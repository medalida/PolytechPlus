package com.server.cinemaepul.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.cinemaepul.charcter.Character;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "movie")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "original_title", nullable = false, length = 100)
    private String original_title;

    @Column(name = "original_language", nullable = false, length = 10)
    private String original_language;

    @Column(name = "release_date", nullable = false)
    private LocalDate release_date;

    @Column(name = "runtime", nullable = false)
    private Integer runtime;

    @Column(name = "popularity", nullable = false)
    private double popularity;

    @Column(name = "poster_path")
    private String poster_path;

    @Column(name = "backdrop_path")
    private String backdrop_path;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "revenue")
    private Integer revenue;

    @Column(name = "overview")
    private String overview;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Character> characters;
}