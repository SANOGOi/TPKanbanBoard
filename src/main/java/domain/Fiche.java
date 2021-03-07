package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Fiche {

    private long id;
    private String libelle;
    private Date dateButoire;
    private String lieu;
    private String url;
    private String note;

    private Utilisateur utilisateur;
    private List<Tags> tags = new ArrayList<Tags>();
    private Section section;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @OneToMany(mappedBy = "fiche", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags.addAll(tags);
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void addTags(Tags tag) {

        tag.setFiche(this);
        List<Tags> listTags = new ArrayList<Tags>();
        listTags.add(tag);
        this.setTags(listTags);
    }
}