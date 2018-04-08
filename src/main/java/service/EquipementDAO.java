package service;

import domain.Equipement;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EquipementDAO implements GenericDAO<Equipement,Long>{
    public static List<Equipement> getEquipements(){
        return EntityManagerHelper.getEntityManager().createQuery("Select eq from Equipement eq", Equipement.class).getResultList();
    }

    public static Equipement getEquipementById(Long id){
        return EntityManagerHelper.getEntityManager().createQuery("Select eq from Equipement eq where eq.id=:id", Equipement.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    public  Equipement create(Equipement equipement) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(equipement);
        EntityManagerHelper.commit();
        return equipement;
    }

    public Equipement read(Long id) {
        return EntityManagerHelper.getEntityManager().find(Equipement.class, id);
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
//        EntityManager manager = factory.createEntityManager();
//        Equipement equipement = manager.find(Equipement.class,id);
//        manager.close();
//        factory.close();
//        return equipement;
    }


    public Equipement update(Equipement equipement) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().merge(equipement);
        EntityManagerHelper.commit();
        return equipement;
    }


    public void delete(Equipement equipement) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(equipement);
        EntityManagerHelper.commit();
    }
}
