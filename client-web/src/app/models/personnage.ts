import {Film} from "./film";
import {Acteur} from "./acteur";

export class Personnage {
  acteur: Acteur;
  film: Film;
  nomPers: string;

  constructor(acteur: Acteur, film: Film, nomPers: string) {
    this.acteur = acteur;
    this.film = film;
    this.nomPers = nomPers;
  }

  static adapt(item: any): Personnage {
    return new Personnage(item.acteur, item.film, item.nomPers)
  }
}
