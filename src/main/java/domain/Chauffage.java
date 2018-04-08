package domain;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
@NamedQueries({
        @NamedQuery(
                name = "Chauffage.findLesChauffages",
                query = "select c from Chauffage c"
        ),
        @NamedQuery(
                name = "Chauffage.findChauffageById",
                query = "select c from Chauffage c where c.idCh = :id"
        )
})

@Entity

public class Chauffage extends IntelligentPeripherik {
    Long idCh;
    private Residence residence;
    private String power;


    public Chauffage() {

        super();
    }

    @Id
    @GeneratedValue
    public Long getIdCh() {
        return idCh;
    }

    public void setIdCh(Long idCh) {
        this.idCh = idCh;
    }

    @ManyToOne
    public Residence getResidence() {

        return this.residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;

    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public int getConsommation() {
        return super.getConsommation();
    }

    @Override
    public void setConsommation(int consommation) {
        super.setConsommation(consommation);
    }
}