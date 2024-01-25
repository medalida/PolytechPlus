package com.server.cinemaepul.charcter;

import com.server.cinemaepul.actor.Actor;
import com.server.cinemaepul.actor.ActorService;
import com.server.cinemaepul.movie.Movie;
import com.server.cinemaepul.movie.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonnageService {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;

    public Character getByIdOrThrow(Integer character_id) {

        return characterRepository.findById(character_id)
                .orElseThrow(() -> {
                    log.error("Personnage {} {} non trouvé en base", character_id);
                    return new RuntimeException("Le personnage n'a pas été trouvé");
                });
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character create(Character character) {
        return characterRepository.save(character);
    }

    public Character update(Integer character_id, Character character) {
        Character oldCharacter = getByIdOrThrow(character_id);
        character.setId(oldCharacter.getId());
        return characterRepository.save(character);
    }

    public Integer delete(Integer character_id) {
        Character character = getByIdOrThrow(character_id);
        characterRepository.delete(character);
        return character.getId();
    }

    public List<Character> getCharactersByActor(Integer actor_id){
        Actor actor = actorService.getByIdOrThrow(actor_id);
        return characterRepository.findAllByActor(actor_id);
    }

    public List<Character> getCharactersByMovie(Integer movie_id) {
        Movie movie = movieService.getByIdOrThrow(movie_id);
        return characterRepository.findByMovie(movie);
    }

    public List<Character> getPersonnagesByFilmId(Integer idFilm) {
        Movie movie = movieService.getByIdOrThrow(idFilm);
        return characterRepository.findByMovie(movie);
    }
}
