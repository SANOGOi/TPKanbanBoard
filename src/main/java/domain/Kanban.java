package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kanban {

    private String titreProjet;
    private long id;
    private List<Section> sections = new ArrayList<Section>();


    public String getTitreProjet() {
        return titreProjet;
    }

    public void setTitreProjet(String titreProjet) {
        this.titreProjet = titreProjet;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Kanban (){
        sections = new ArrayList<>();
    }

    @OneToMany(mappedBy = "kanban", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections.addAll(sections);
    }

    public void addSection(Section section) {
        section.setKanban(this);
        List<Section> listSection = new ArrayList<Section>();
        listSection.add(section);
        this.setSections(listSection);
    }

}