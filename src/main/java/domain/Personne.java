package domain;


import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Personne {

  private String nom;
  private long id;
  private String prenom;
  private String mail;
  Collection<Residence> residences = new ArrayList<Residence>();
  //Collection<Personne> amis = new ArrayList<Personne>();
  Collection<Equipement> equipements = new ArrayList<Equipement>();

  public Personne() {
        super();
    }

  @Id
  @GeneratedValue
  public long getId() {

    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {

    this.nom = nom;
  }

  @Column
  public String getPrenom() {

    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Column
  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  @ManyToMany
  @JsonIgnore
  public Collection<Residence> getResidences() {

    return residences;
  }

  public void setResidences(Collection<Residence> residences) {

    this.residences = residences;
  }

  @OneToMany(mappedBy = "pers")
  @JsonIgnore
  public Collection<Equipement> getEquipements() {

    return this.equipements;
  }

  public void setEquipements(Collection<Equipement> equipements) {

    this.equipements = equipements;
  }

//  @OneToMany(mappedBy = "amis")
//  @JsonIgnore
//  public Collection<Personne> getAmis() {
//    return this.amis;
//  }
//
//  public void setAmis(Collection<Personne> amis) {
//    this.amis = amis;
//  }

  public Personne(String nom, String prenom, String mail) {
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;

  }
  @Override
  public String toString() {
    return "Personne [id = " + id + ", Nom = " + nom + ", Prénom = " + prenom + ", email = " + mail + "]";
  }
}



