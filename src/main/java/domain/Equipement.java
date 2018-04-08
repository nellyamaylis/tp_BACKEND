package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Equipement extends IntelligentPeripherik {
  private Long idEq;
  private String nom;
  private int watts;
  Residence residence;
  Personne pers;

  public Equipement() {
    super();
  }

  @Id
  @GeneratedValue
  public Long getIdEq() {
    return idEq;
  }

  public void setIdEq(Long idEq) {
    this.idEq = idEq;
  }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getWatts() {
    return watts;
  }

  public void setWatts(int watts) {
    this.watts = watts;
  }

    @Override
    public int getConsommation() {
        return super.getConsommation();
    }

    @Override
    public void setConsommation(int consommation) {
        super.setConsommation(consommation);
    }

    @ManyToOne
  public Residence getResidence() {
    return residence;
  }

  public void setResidence(Residence residence) {
    this.residence = residence;
  }

  @ManyToOne
  public Personne getPers() {
        return pers;
  }

  public void setPers(Personne pers) {
        this.pers = pers;
  }

    @Override
  public String toString() {
    return "Equipement [id=" + idEq + ", Puissance =" + watts + ", Consommation=" + consommation + "]";
  }
}


