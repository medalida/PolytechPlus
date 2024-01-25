package com.server.cinemaepul.movie;

import com.server.cinemaepul.charcter.Character;
import com.server.cinemaepul.charcter.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private PersonnageService personnageService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie getByIdOrThrow(@PathVariable("id") Integer filmId) {
        return movieService.getByIdOrThrow(filmId);
    }

    @GetMapping("/titre/{titre}")
    public Optional<Movie> getByTitre(@PathVariable("titre") String titre) {
        return movieService.getByTitre(titre);
    }

    @GetMapping("/categorie/{id}")
    public List<Movie> getByCategorie(@PathVariable("id") int id) {return movieService.getAllByCategorie(id);}

    @GetMapping("/realisateur/{noRea}")
    public List<Movie> getAllByRealisateur(@PathVariable("noRea") Integer noRea) {return movieService.getAllByDirector(noRea);}

//    @GetMapping("/search/{value}")
//    public List<Movie> getBySearch(@PathVariable("value") String value) {
//        return movieService.getAllBySearch(value);
//    }

    @GetMapping("/{id}/characters")
    public List<Character> getCharacterByMovie(@PathVariable("id") Integer movie_id) {
        try {
            return personnageService.getCharactersByMovie(movie_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/best")
        public List<Movie> getBestFilms() {
            return movieService.getBestFilms();
        }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable("id") Integer movie_id,
                        @RequestBody Movie movie) {
        return movieService.update(movie_id, movie);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer filmId) {
        return movieService.delete(filmId);
    }
}
