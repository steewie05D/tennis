package entity;

public class Epreuve {
    private Long id;
    private Short annne;
    //private Tournoi tournoi;

    private Character  typeEpreuve;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAnnne() {
        return annne;
    }

    public void setAnnne(Short annne) {
        this.annne = annne;
    }

  /*  public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }
*/
    public Character getTypeEpreuve() {
        return typeEpreuve;
    }

    public void setTypeEpreuve(Character typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }
}