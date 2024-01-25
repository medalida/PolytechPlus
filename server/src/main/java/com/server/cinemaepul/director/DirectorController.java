package com.server.cinemaepul.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> findAll() {
        return directorService.findAll();
    }

    @GetMapping("/{id}")
    public Director getByIdOrThrow(@PathVariable("id") Integer realisateurId) {
        return directorService.getByIdOrThrow(realisateurId);
    }

//    @GetMapping("/nom/{nom}")
//    public Director getByNom(@PathVariable("nom") String nom) {
//        return realisateurService.findByNom(nom);
//    }

    @PostMapping
    public Director create(@RequestBody Director director) {
        return directorService.create(director);
    }

    @PutMapping("/{id}")
    public Director update(@PathVariable("id") Integer realisateurId,
                           @RequestBody Director director) {
        return directorService.update(realisateurId, director);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer realisateurId) {
        return directorService.delete(realisateurId);
    }
}
