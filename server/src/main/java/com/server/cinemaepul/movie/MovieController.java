package com.server.cinemaepul.movie;

import com.server.cinemaepul.charcter.Character;
import com.server.cinemaepul.charcter.PersonnageService;
import com.server.cinemaepul.director.Director;
import com.server.cinemaepul.director.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private PersonnageService personnageService;

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getByIdOrThrow(@PathVariable("id") Integer filmId) {
        return Optional
                .ofNullable( movieService.getByIdOrThrow(filmId) )
                .map( user -> ResponseEntity.ok().body(user) )
                .orElseGet( () -> ResponseEntity.notFound().build() );
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

    @GetMapping("/{id}/director")
    public Director getDirectorByMovie(@PathVariable("id") Integer movie_id) {
        try {
            Movie movie = movieService.getByIdOrThrow(movie_id);
            return directorService.getByIdOrThrow(movie.getDirector_id());
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
    public ResponseEntity<Movie> update(@PathVariable("id") Integer movie_id,
                        @RequestBody Movie movie) {
        return Optional
                .ofNullable( movieService.update(movie_id, movie) )
                .map( user -> ResponseEntity.ok().body(user) )
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Integer filmId) {
        return Optional
                .ofNullable( movieService.delete(filmId) )
                .map( user -> ResponseEntity.ok().body(user) )
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }
}
