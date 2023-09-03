package entity;

public class Match {

    private Long id;
    private Joueur vainqueur;
    private Joueur finaliste;
    private Epreuve epreuve;

    private Score score;

    public entity.Score getScore() {
        return score;
    }

    public void setScore(entity.Score score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public entity.Joueur getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(entity.Joueur vainqueur) {
        this.vainqueur = vainqueur;
    }

    public entity.Joueur getFinaliste() {
        return finaliste;
    }

    public void setFinaliste(entity.Joueur finaliste) {
        this.finaliste = finaliste;
    }

    public entity.Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(entity.Epreuve epreuve) {
        this.epreuve = epreuve;
    }
}
