package istic.m2ila.taa.tp1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meteo {

	private long id;
	private double vent;
	private double directionVent;
	private double temperature;
	private String description;
	private int pluie; // de 0=très forte pluie à 3=pas de pluie
	private int ciel; // de 0=très nuageux à 3=aucun nuage

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getVent() {
		return vent;
	}

	public void setVent(double vent) {
		this.vent = vent;
	}

	public double getDirectionVent() {
		return directionVent;
	}

	public void setDirectionVent(double directionVent) {
		this.directionVent = directionVent;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPluie() {
		return pluie;
	}

	public void setPluie(int pluie) {
		this.pluie = pluie;
	}

	public int getCiel() {
		return ciel;
	}

	public void setCiel(int ciel) {
		this.ciel = ciel;
	}

}
