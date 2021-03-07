package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Utilisateur {

    private Long id;
    private String speudo;
    private String poste;

    private List<Fiche> fiches = new ArrayList<Fiche>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpeudo() {
        return speudo;
    }

    public void setSpeudo(String speudo) {
        this.speudo = speudo;
    }

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches.addAll(fiches);
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void addFiches(Fiche fiche) {
        fiche.setUtilisateur(this);
        List<Fiche> listeFiches = new ArrayList<Fiche>();
        listeFiches.add(fiche);
        this.setFiches(listeFiches);
    }
}