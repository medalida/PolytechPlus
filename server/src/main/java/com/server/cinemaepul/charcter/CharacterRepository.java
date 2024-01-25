package com.server.cinemaepul.charcter;

import com.server.cinemaepul.actor.Actor;
import com.server.cinemaepul.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    List<Character> findAllByActor(Actor actor);
    List<Character> findByMovie(Movie movie);
}

