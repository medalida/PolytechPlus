package com.server.cinemaepul.charcter;

import com.server.cinemaepul.actor.Actor;
import com.server.cinemaepul.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query(value="select * from `character` where actor_id=?", nativeQuery = true)
    List<Character> findAllByActor(int actor_id);
    List<Character> findByMovie(Movie movie);
}

