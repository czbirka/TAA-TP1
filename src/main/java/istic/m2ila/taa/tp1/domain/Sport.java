package istic.m2ila.taa.tp1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sport {

	long id;

	String nom;

	private List<Person> persons = new ArrayList<Person>();
	private List<Lieu> lieux = new ArrayList<Lieu>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@ManyToMany(mappedBy = "sports")
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@ManyToMany
	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
}
