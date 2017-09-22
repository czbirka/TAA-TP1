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

import istic.m2ila.taa.tp1.domain.Person;

public class PersonDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();
    
	//public PersonDAO() {
	//	super(manager);
	//}

	//@Override
	public boolean create(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public List<Person> findAll() {
		List<Person> result = new ArrayList<Person>();
		try {
			result = manager.createQuery("select p from Person as p")
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Optional<Person> findOneById(long id) {
		Optional<Person> person = Optional.empty();
		try {
			person = Optional.of(manager.createQuery("select p from Person as p where p.id = :id", Person.class)
					.setParameter("id", id)
					.getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public Optional<Person> findOneByName(String name) {
		Optional<Person> person = Optional.empty();
		try {
			person = Optional.of(manager.createQuery("select p from Person as p where p.name = :name", Person.class)
					.setParameter("name", name)
					.getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}

}
