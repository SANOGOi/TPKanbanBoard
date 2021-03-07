package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {

    private Long id;
    private String state;

    private Kanban kanban;
    private List<Fiche> fiches = new ArrayList<Fiche>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Kanban getKanban() {
        return kanban;
    }

    public void setKanban(Kanban kanban) {
        this.kanban = kanban;
    }

    @OneToMany(mappedBy = "section", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches.addAll(fiches);
    }

    public void addFiches(Fiche fiche) {
        fiche.setSection(this);
        List<Fiche> listeFiches = new ArrayList<Fiche>();
        listeFiches.add(fiche);
        this.setFiches(listeFiches);
    }
}