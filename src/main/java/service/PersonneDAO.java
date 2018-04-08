package service;

import domain.Personne;
import domain.Residence;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class PersonneDAO implements GenericDAO<Personne,Long>{
    public Personne create(Personne personne) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(personne);
        EntityManagerHelper.commit();
        return personne;
    }



    public Personne read(Long id) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
//        EntityManager manager = factory.createEntityManager();
//        Personne personne = manager.find(Personne.class,id);
//        manager.close();
//        factory.close();
        return EntityManagerHelper.getEntityManager().find(Personne.class, id);
    }

    public List<Personne> readByNom(String nom) {
        return EntityManagerHelper.getEntityManager().createQuery("select p from Personne as p where p.nom=:nom")
                .setParameter("nom",nom)
                .getResultList();

    }

    public static List<Personne> readAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select p from Personne as p").getResultList();

    }


    public List<Personne> readByResidences( Collection<Residence> residences) {
        return EntityManagerHelper.getEntityManager().createQuery("select p from Personne as p where p.residences=:residence")
                .setParameter("residence",residences)
                .getResultList();

    }

    public Personne update(Personne personne) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().merge(personne);
        EntityManagerHelper.commit();
        return personne;
    }

    public void delete(Personne personne) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(personne);
        EntityManagerHelper.commit();

    }

}
