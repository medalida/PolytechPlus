package com.server.cinemaepul.movie_genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.cinemaepul.movie.Movie;
import lombok.*;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categorie")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MovieGenreId.class)
public class MovieGenre {
    @Id
    @Column(name = "movie_id", nullable = false)
    private int movie_id;

    @Id
    @Column(name = "genre_id", nullable = false)
    private int genre_id;
}

