package com.server.cinemaepul.charcter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnages")
public class CharacterController {
    @Autowired
    private PersonnageService personnageService;

    @GetMapping
    public List<Character> findAll() {
        return personnageService.findAll();
    }

    @RequestMapping("/{idAct}-{idFilm}")
    public Character getByIdOrThrow(@PathVariable("character_id") Integer character_id) {
        return personnageService.getByIdOrThrow(character_id);
    }

    @PostMapping
    public Character create(@RequestBody Character character) {
        return personnageService.create(character);
    }

    @PutMapping("/{idAct}-{idFilm}")
    public Character update(@PathVariable("character_id") Integer character_id,
                            @RequestBody Character character) {
        return personnageService.update(character_id, character);
    }

    @DeleteMapping("/{character_id}")
        public Integer delete(@PathVariable("character_id") Integer character_id) {
        return personnageService.delete(character_id);
    }

    @GetMapping("/film/{filmId}")
    public List<Character> getPersonnagesByFilm(@PathVariable("filmId") Integer filmId) {
        try {
            return personnageService.getPersonnagesByFilmId(filmId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
