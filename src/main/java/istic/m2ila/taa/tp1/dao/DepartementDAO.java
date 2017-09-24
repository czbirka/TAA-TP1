package istic.m2ila.taa.tp1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import istic.m2ila.taa.tp1.domain.Departement;

public class DepartementDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	
	public List<Departement> findAll() {
		List<Departement> result = new ArrayList<Departement>();
		try {
			result = manager.createQuery("select d from Departement as d").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Optional<Departement> findOneById(long id) {
		Optional<Departement> departement = Optional.empty();
		try {
			departement = Optional.of(manager.createQuery("select d from Departement as d where d.id = :id", Departement.class)
					.setParameter("id", id).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departement;
	}
	
	public Optional<Departement> findOneByName(String name) {
		Optional<Departement> departement = Optional.empty();
		try {
			departement = Optional.of(manager.createQuery("select d from Departement as d where d.nom = :name", Departement.class)
					.setParameter("name", name).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departement;
	}
	
	public boolean create(Departement d) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(d);
		tx.commit();
		return true;
	}
	
	public boolean update(Departement d) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(d);
		tx.commit();
		return true;
	}

	public boolean delete(Departement d) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(d);
		tx.commit();
		return true;
	}

}
