package com.server.cinemaepul.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    @Autowired
    private RealisateurService realisateurService;

    @GetMapping
    public List<Director> findAll() {
        return realisateurService.findAll();
    }

    @GetMapping("/{id}")
    public Director getByIdOrThrow(@PathVariable("id") Integer realisateurId) {
        return realisateurService.getByIdOrThrow(realisateurId);
    }

//    @GetMapping("/nom/{nom}")
//    public Director getByNom(@PathVariable("nom") String nom) {
//        return realisateurService.findByNom(nom);
//    }

    @PostMapping
    public Director create(@RequestBody Director director) {
        return realisateurService.create(director);
    }

    @PutMapping("/{id}")
    public Director update(@PathVariable("id") Integer realisateurId,
                           @RequestBody Director director) {
        return realisateurService.update(realisateurId, director);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer realisateurId) {
        return realisateurService.delete(realisateurId);
    }
}
