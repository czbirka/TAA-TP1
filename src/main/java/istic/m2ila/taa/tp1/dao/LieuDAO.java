package istic.m2ila.taa.tp1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.jdbc.Connection;

import istic.m2ila.taa.tp1.domain.Lieu;
import istic.m2ila.taa.tp1.domain.Person;

public class LieuDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

//	public LieuDAO(EntityManager manager) {
//		super(manager);
//		// TODO Auto-generated constructor stub
//	}

	public List<Lieu> findAll() {
		List<Lieu> result = new ArrayList<Lieu>();
		try {
			result = manager.createQuery("select l from Lieu as l").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Optional<Lieu> findOneById(long id) {
		Optional<Lieu> lieu = Optional.empty();
		try {
			lieu = Optional.of(manager.createQuery("select l from Lieu as l where l.id = :id", Lieu.class)
					.setParameter("id", id).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lieu;
	}
	
	public Optional<Lieu> findOneByName(String name) {
		Optional<Lieu> lieu = Optional.empty();
		try {
			lieu = Optional.of(manager.createQuery("select l from Lieu as l where l.nom = :name", Lieu.class)
					.setParameter("name", name).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lieu;
	}
	
	
	public boolean create(Lieu l) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(l);
		tx.commit();
		return true;
	}
	
	public boolean update(Lieu l) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(l);
		tx.commit();
		return true;
	}

	public boolean delete(Lieu l) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(l);
		tx.commit();
		return true;
	}



	public Lieu find(String name) {
		Query q = manager.createQuery("select l from Lieu as l where l.name = :name");
		q.setParameter("name", name);
		Lieu l = (Lieu) q.getSingleResult();
		return l;
	}



}
