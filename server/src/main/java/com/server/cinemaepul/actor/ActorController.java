package com.server.cinemaepul.actor;

import com.server.cinemaepul.charcter.Character;
import com.server.cinemaepul.charcter.PersonnageAvecFilmDto;
import com.server.cinemaepul.charcter.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @Autowired
    private PersonnageService personnageService;

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping
    List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getByIdOrThrow(@PathVariable("id") Integer actor_id){
        return Optional
                .ofNullable( actorService.getByIdOrThrow(actor_id) )
                .map( user -> ResponseEntity.ok().body(user) )
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @PostMapping
    public Actor create(@RequestBody Actor actor) {
        return actorService.create(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable("id") Integer actor_id,
                        @RequestBody Actor actor) {
        return Optional
                .ofNullable( actorService.update(actor_id, actor) )
                .map( user -> ResponseEntity.ok().body(user) )
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Integer actor_id) {
        return Optional
                .ofNullable( actorService.delete(actor_id) )
                .map( user -> ResponseEntity.ok().body(user) )
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @GetMapping("/{id}/characters")
    public List<Character> getCharactersByActor(@PathVariable("id") Integer actor_id) {
        try {
            return personnageService.getCharactersByActor(actor_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
