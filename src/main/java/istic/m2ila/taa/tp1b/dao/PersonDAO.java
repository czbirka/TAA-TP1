package istic.m2ila.taa.tp1b.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mysql.jdbc.Connection;

import istic.m2ila.taa.tp1b.domain.Person;

public class PersonDAO extends DAO<Person> {
	
	public PersonDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public boolean create(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person find(long id) {
		Query q = manager.createQuery("select p from Person as p where p.id = :id");
		q.setParameter("id", id);
		Person p = (Person) q.getSingleResult();
		return p;
	}
	
	public Person find(String name, String firstName) {
		Query q = manager.createQuery("select p from Person as p where p.name = :name and p.firstName = :firstName");
		q.setParameter("name", name);
		q.setParameter("firstName", firstName);
		Person p = (Person) q.getSingleResult();
		return p;
	}
	
	public List<Person> find() {
		Query q = manager.createQuery("select p from Person as p");
		List<Person> result = q.getResultList();
		return result;
	}

	@Override
	public List<Person> findAll(long id) {
		Query q = manager.createQuery("select p from Person as p");
		List<Person> result = q.getResultList();
		return result;
	}
	
	

}
