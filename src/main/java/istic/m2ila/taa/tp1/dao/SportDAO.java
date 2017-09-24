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
import istic.m2ila.taa.tp1.domain.Sport;

public class SportDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

//	public SportDAO(EntityManager manager) {
//		super(manager);
//		// TODO Auto-generated constructor stub
//	}
	
	public List<Sport> findAll() {
		List<Sport> result = new ArrayList<Sport>();
		try {
			result = manager.createQuery("select s from Sport as s").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Optional<Sport> findOneById(long id) {
		Optional<Sport> sport = Optional.empty();
		try {
			sport = Optional.of(manager.createQuery("select s from Sport as s where s.id = :id", Sport.class)
					.setParameter("id", id).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sport;
	}
	
	public Optional<Sport> findOneByName(String name) {
		Optional<Sport> sport = Optional.empty();
		try {
			sport = Optional.of(manager.createQuery("select s from Sport as s where s.nom = :name", Sport.class)
					.setParameter("name", name).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sport;
	}
	
	public boolean create(Sport s) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(s);
		tx.commit();
		return true;
	}
	
	public boolean update(Sport s) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(s);
		tx.commit();
		return true;
	}

	public boolean delete(Sport s) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(s);
		tx.commit();
		return true;
	}
	
}
