package com.server.cinemaepul.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Movie, Integer> {
    Movie findByTitle(String titre);

    //List<Movie> findAllByCodeCat(MovieGenre codeCat);

    //List<Movie> findAllBySearch(@Param("value") String value);


}
