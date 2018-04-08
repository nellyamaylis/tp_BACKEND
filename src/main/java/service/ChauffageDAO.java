package service;

import domain.Chauffage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ChauffageDAO implements GenericDAO<Chauffage, Long>{

    public static List<Chauffage> getChauffages(){
        return EntityManagerHelper.getEntityManager().createQuery("Select c from Chauffage c", Chauffage.class).getResultList();
    }
    public static Chauffage getChauffageById(Long id){
        return EntityManagerHelper.getEntityManager().createQuery("Select c from Chauffage c where c.id=:id", Chauffage.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    public  Chauffage create(Chauffage chauffage) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(chauffage);
        EntityManagerHelper.commit();
        return chauffage;
    }


    public Chauffage read(Long id) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
//        EntityManager manager = factory.createEntityManager();
//        Chauffage chauffage = manager.find(Chauffage.class,id);
//        manager.close();
//        factory.close();
        return EntityManagerHelper.getEntityManager().find(Chauffage.class, id);
    }


    public Chauffage update(Chauffage chauffage) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().merge(chauffage);
        EntityManagerHelper.commit();
        return chauffage;
    }


    public void delete(Chauffage chauffage) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(chauffage);
        EntityManagerHelper.commit();
    }
}
