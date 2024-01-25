package com.server.cinemaepul.actor;

import com.server.cinemaepul.charcter.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public Actor getByIdOrThrow(Integer actor_id) {
        System.out.println(actorRepository.findById(actor_id));
        return actorRepository.findById(actor_id).orElse(null);
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    /**
     * Crée un acteur en base
     *
     * @param actorInput actorInput
     * @return acteur créé
     */
    public Actor create(Actor actorInput) {
        return actorRepository.save(actorInput);
    }

    /**
     * Met à jour un acteur en base
     *
     * @param actor_id    id acteur
     * @param actor actorInput
     * @return acteur mis à jour
     */
    public Actor update(Integer actor_id, Actor actor) {
        Actor old_actor = getByIdOrThrow(actor_id);
        if (old_actor == null) return null;
        actor.setId(actor_id);
        return actorRepository.save(actor);
    }

    /**
     * Supprime un acteur en base
     *
     * @param acteurId id acteur
     * @return id acteur supprimé
     */
    public Integer delete(Integer acteurId) {
        Actor acteur = getByIdOrThrow(acteurId);
        actorRepository.delete(acteur);
        return acteurId;
    }
}
