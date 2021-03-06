package domain;

import javax.persistence.*;
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
    private List<Tags> tags;
    private Section section;

    public Fiche(String libelle, Date dateButoire, String lieu, String url, String note) {
        this.libelle = libelle;
        this.dateButoire = dateButoire;
        this.lieu = lieu;
        this.url = url;
        this.note = note;
    }

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

    @ManyToOne
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @OneToMany(mappedBy = "fiche", fetch = FetchType.EAGER)
    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
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

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
