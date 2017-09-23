package istic.m2ila.taa.tp1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import istic.m2ila.taa.tp1.domain.Region;

public class RegionDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	
	public List<Region> findAll() {
		List<Region> result = new ArrayList<Region>();
		try {
			result = manager.createQuery("select r from Region as r").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Optional<Region> findOneById(long id) {
		Optional<Region> region = Optional.empty();
		try {
			region = Optional.of(manager.createQuery("select r from Region as r where r.id = :id", Region.class)
					.setParameter("id", id).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return region;
	}
	
	public Optional<Region> findOneByName(String name) {
		Optional<Region> region = Optional.empty();
		try {
			region = Optional.of(manager.createQuery("select r from Region as r where r.nom = :name", Region.class)
					.setParameter("name", name).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return region;
	}
	
	public boolean create(Region r) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(r);
		tx.commit();
		return true;
	}
	
	public boolean update(Region r) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(r);
		tx.commit();
		return true;
	}
	
	public boolean delete(Region r) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(r);
		tx.commit();
		return true;
	}
	
}
