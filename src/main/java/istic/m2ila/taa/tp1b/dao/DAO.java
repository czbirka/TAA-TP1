package istic.m2ila.taa.tp1b.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mysql.jdbc.Connection;


public abstract class DAO<T> {

	protected EntityManager manager = null;

	public DAO(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Méthode de création
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * 
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * 
	 * @return boolean
	 * 
	 */
	public abstract boolean delete(T obj);

	/**
	 * 
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * 
	 * @return boolean
	 * 
	 */
	public abstract boolean update(T obj);
	
	/**
	 * 
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * 
	 * @return T
	 * 
	 */
	public abstract T find(long id);
	
	public abstract List<T> findAll(long id);

}
