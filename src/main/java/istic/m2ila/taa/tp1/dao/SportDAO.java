package istic.m2ila.taa.tp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mysql.jdbc.Connection;

import istic.m2ila.taa.tp1.domain.Lieu;
import istic.m2ila.taa.tp1.domain.Person;
import istic.m2ila.taa.tp1.domain.Sport;

public class SportDAO extends DAO<Sport> {

	public SportDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sport find(long id) {
		return manager.find(Sport.class, id);
	}
	
	public Sport find(String name) {
		Query q = manager.createQuery("select sfrom Sport as s where s.name = :name");
		q.setParameter("name", name);
		Sport s = (Sport) q.getSingleResult();
		return s;
	}

	@Override
	public List<Sport> findAll(long id) {
		Query q = manager.createQuery("select s from Sport as s");
		List<Sport> result = q.getResultList();
		return result;
	}

	
}
