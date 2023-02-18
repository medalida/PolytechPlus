package com.server.cinemaepul.realisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.cinemaepul.film.Film;
import lombok.*;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "realisateur")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_rea", nullable = false)
    private Integer id;

    @Column(name = "nom_rea", nullable = false, length = 20)
    private String nomRea;

    @Column(name = "pren_rea", nullable = false, length = 20)
    private String prenRea;

    @JsonIgnore
    @OneToMany(mappedBy = "noRea")
    private Set<Film> films = new LinkedHashSet<>();

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public String getPrenRea() {
        return prenRea;
    }

    public void setPrenRea(String prenRea) {
        this.prenRea = prenRea;
    }

    public String getNomRea() {
        return nomRea;
    }

    public void setNomRea(String nomRea) {
        this.nomRea = nomRea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}