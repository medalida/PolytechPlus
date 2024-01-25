package com.server.cinemaepul.movie;

import com.server.cinemaepul.movie_genre.CategorieService;
import com.server.cinemaepul.director.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MovieService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private DirectorService directorService;

    public Movie getByIdOrThrow(Integer filmId) {
        return filmRepository.findById(filmId).orElse(null);
    }

    public Optional<Movie> getByTitre(String titre) {
        return Optional.of(filmRepository.findByTitle(titre));
    }

    public List<Movie> findAll() {
        return filmRepository.findAll();
    }

    public List<Movie> getAllByCategorie(int id) {
        return new ArrayList<>();
    }

    public List<Movie> getAllByDirector(Integer noRea) {
        //return filmRepository.findAllById(realisateurService.getByIdOrThrow(noRea));
        return new ArrayList<>();
    }

    public List<Movie> getBestFilms() {
        return filmRepository.findAll(PageRequest.of(0, 5)).getContent();
    }

    public Movie create(Movie movie) {
        return filmRepository.save(movie);
    }

    public Movie update(Integer movie_id, Movie movie) {
        Movie old_movie = getByIdOrThrow(movie_id);
        if (old_movie == null) return null;
        movie.setId(old_movie.getId());
        return filmRepository.save(movie);
    }

    public Integer delete(Integer movie_id) {
        filmRepository.deleteById(movie_id);
        return movie_id;
    }

//    public List<Movie> getAllBySearch(String value) {
//        return filmRepository.findAllBySearch(value);
//    }
}
