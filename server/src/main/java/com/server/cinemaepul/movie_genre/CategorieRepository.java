package com.server.cinemaepul.movie_genre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<MovieGenre, Integer> {
//    MovieGenre findByLibelleCat(String libelleCat);
//    MovieGenre findById(String id);
//    String deleteById(String id);
}
