package jpa;

import domain.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JpaTest {

	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.initialisation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listPerson();
		test.getLesResidences();
		test.findLesChauffages();
		test.findChauffageById(1);
		//String s = "SELECT e FROM Personne as e where e.nom=:nom";


		//Query q = manager.createQuery(s,Personne.class);
		//Query m = manager.createNamedQuery("Select );

		//q.setParameter("nom", "martin");
		//List<Personne> res = q.getResultList();

		//System.err.println(res.size());
//		System.err.println(res.get(0).getNom());

		manager.close();
		factory.close();

	}
	public void initialisation() {
		// Residences
        Collection<Residence> List1Residence = new ArrayList<Residence>();
		Residence a =  new Residence();
		Residence b =  new Residence();
		a.setTaille(1000);
		a.setNb_pieces(8);
		b.setTaille(2000);
		b.setNb_pieces(15);
		List1Residence.add(a);
		List1Residence.add(b);

		Residence c = new Residence();
		c.setTaille(500);
		c.setNb_pieces(4);
		List1Residence.add(c);

		Collection<Residence> List2Residence = new ArrayList<Residence>();
		Residence d = new Residence();
		d.setTaille(3000);
		d.setNb_pieces(25);
		List2Residence.add(d);

       // Personnes
		Personne p0 = new Personne();
		p0.setNom("marlene");
		p0.setPrenom("akimana");
		p0.setMail("akimana@yahoo.fr");
		p0.setResidences(List2Residence);

		Personne p1 = new Personne();
		p1.setNom("laura");
		p1.setPrenom("akira");
		p1.setMail("akira@yahoo.fr");
		p1.setResidences(List1Residence);

		Personne p2 = new Personne();
		p2.setNom("Maylis");
		p2.setPrenom("Bianca");
		p2.setMail("nel@gmail.com");
		p2.setResidences(List1Residence);

		// Chauffages
        Collection<Chauffage> List1Chauffage = new ArrayList<Chauffage>();
		Chauffage ch0 = new Chauffage();
		ch0.setConsommation(200);
		ch0.setPower("1000");
		List1Chauffage.add(ch0);

		Collection<Chauffage> List2Chauffage = new ArrayList<Chauffage>();
		Chauffage ch1 = new Chauffage();
		ch1.setPower("2000");
		ch1.setConsommation(90);
		List2Chauffage.add(ch1);

		Chauffage ch2 = new Chauffage();
		ch2.setConsommation(75);
		ch2.setPower("1000");
		List2Chauffage.add(ch2);

		ch0.setResidence(a);
		ch1.setResidence(b);
		ch2.setResidence(b);
		ch0.setResidence(d);

		a.setChauffage(List1Chauffage);
		b.setChauffage(List2Chauffage);
		d.setChauffage(List1Chauffage);

        // Equipements
        Collection<Equipement> List1Equipement = new ArrayList<Equipement>();
        Collection<Equipement> List2Equipement = new ArrayList<Equipement>();
		Equipement device1 = new Equipement();
		device1.setWatts(220);
		device1.setNom("LecteurCD");
		device1.setConsommation(200);
		device1.setResidence(a);

		Equipement device2 = new Equipement();
		device2.setConsommation(500);
		device2.setWatts(800);
		device2.setNom("Television");
		device2.setResidence(a);

        Equipement device3 = new Equipement();
        device3.setConsommation(100);
        device3.setWatts(150);
        device3.setNom("FAX");
        device3.setResidence(b);

        Equipement device4 = new Equipement();
        device4.setConsommation(200);
        device4.setWatts(280);
        device4.setNom("Interphone");
        device4.setResidence(b);

        List1Equipement.add(device1);
        List1Equipement.add(device2);
        List2Equipement.add(device3);
        List2Equipement.add(device4);

        a.setEquipements(List1Equipement);
        b.setEquipements(List2Equipement);

        manager.persist(a);
        manager.persist(b);
        manager.persist(c);
        manager.persist(d);
        manager.persist(p0);
        manager.persist(p1);
        manager.persist(p2);
        manager.persist(ch0);
        manager.persist(ch1);
        manager.persist(ch2);
        manager.persist(device1);
        manager.persist(device2);
        manager.persist(device3);
        manager.persist(device4);
	}

    private void listPerson() {
        List<Personne> resultList = manager.createQuery("Select p From Personne p", Personne.class).getResultList();
        System.out.println("num of person:" + resultList.size());
        for (Personne next : resultList) {
            System.out.println("next person: " + next);
        }
    }


    public void getLesResidences() {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<Residence> from = criteriaQuery.from(Residence.class);
        CriteriaQuery<Object> select = criteriaQuery.select(from);

        TypedQuery<Object> typedQuery = manager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();

        for (Object o : resultList) {
            System.out.println("CriteriaQuery ---> ID DES RESIDENCES : " + ((Residence) o).getId());
        }
    }

    public void findLesChauffages() {
        List<Chauffage> results = manager.createNamedQuery("Chauffage.findLesChauffages").getResultList();
        for (Chauffage h : results) {
            System.out.println("NamedQuery ---> CHAUFFAGE : " + h.getIdCh());
        }
    }

    public void findChauffageById(int id) {
        Object result = manager.createNamedQuery("Chauffage.findChauffageById").setParameter("id", id).getSingleResult();

        System.out.println("NamedQuery ---> CHAUFFAGE POWER : " + ((Chauffage) result).getPower());
    }

}
