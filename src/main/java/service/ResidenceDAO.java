package service;

import domain.Residence;

import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ResidenceDAO implements GenericDAO<Residence,Long>{

    public  List<Residence> getResidences(){
        return EntityManagerHelper.getEntityManager().createQuery("Select r from Residence r", Residence.class).getResultList();
    }

    public static Residence getResidenceById(Long id){
        return EntityManagerHelper.getEntityManager().createQuery("Select r from Residence r where r.id=:id", Residence.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public  Residence create(Residence residence) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(residence);
        EntityManagerHelper.commit();
        return residence;
    }

    public Residence read(Long id) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
//        EntityManager manager = factory.createEntityManager();
//        Residence residence = manager.find(Residence.class,id);
//        manager.close();
//        factory.close();
        return EntityManagerHelper.getEntityManager().find(Residence.class,id);
    }


    public Residence update(Residence residence) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().merge(residence);
        EntityManagerHelper.commit();
        return residence;
    }


    public void delete(Residence residence) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(residence);
        EntityManagerHelper.commit();
    }
}
