package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;


@Entity
public class Residence {
    private long id;
    private int taille;
    private int nb_pieces;
    Collection<Personne> proprios = new ArrayList<Personne>();
    Collection<Chauffage> chauffage = new ArrayList<Chauffage>();
    Collection<Equipement> equipements = new ArrayList<Equipement>();

  public Residence() {

    super();
  }

  public Residence(int taille, int nb_pieces) {
    this.taille = taille;
    this.nb_pieces = nb_pieces;
  }
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTaille() {

    return taille;
  }

  public void setTaille(int taille) {
    this.taille = taille;

  }

  public int getNb_pieces() {

    return nb_pieces;
  }

  public void setNb_pieces(int nb_pieces) {

    this.nb_pieces = nb_pieces;
  }

    @ManyToMany(mappedBy = "residences")
    @JsonIgnore
    public Collection<Personne> getProprios() {
        return proprios;
    }

    public void setProprios(Collection<Personne> proprios) {
        this.proprios = proprios;
    }

    @OneToMany(mappedBy = "residence")
    @JsonIgnore
    public Collection<Chauffage> getChauffage() {
        return chauffage;
    }

    public void setChauffage(Collection<Chauffage> chauffage) {
        this.chauffage = chauffage;
    }

    @OneToMany(mappedBy = "residence")
    @JsonIgnore
    public Collection<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(Collection<Equipement> equipements) {
        this.equipements = equipements;
    }


  public void addChauffage(Chauffage ch1) {
    chauffage.add(ch1);

  }
    @Override
    public String toString() {
        return "Residence [id = " + id + ", taille = " + taille + ", nombre de chambres = " + nb_pieces + "]";
    }
}


