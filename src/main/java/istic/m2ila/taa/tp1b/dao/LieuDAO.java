package istic.m2ila.taa.tp1b.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mysql.jdbc.Connection;

import istic.m2ila.taa.tp1b.domain.Lieu;
import istic.m2ila.taa.tp1b.domain.Person;

public class LieuDAO extends DAO<Lieu> {

public LieuDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean create(Lieu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Lieu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Lieu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lieu find(long id) {
		Query q = manager.createQuery("select l from Lieu as l where l.id = :id");
		q.setParameter("id", id);
		Lieu l = (Lieu) q.getSingleResult();
		return l;
	}
	
	public Lieu find(String name) {
		Query q = manager.createQuery("select l from Lieu as l where l.name = :name");
		q.setParameter("name", name);
		Lieu l = (Lieu) q.getSingleResult();
		return l;
	}

	@Override
	public List<Lieu> findAll(long id) {
		Query q = manager.createQuery("select l from Lieu as l");
		List<Lieu> result = q.getResultList();
		return result;
	}

	
}
