package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerson;
	
	private String namePerson;
	private String mailPerson;
	private int dniPerson;
	private String directionPerson;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(int idPerson, String namePerson, String mailPerson, int dniPerson,
			String directionPerson, String userPerson, String passwordPerson) {
		super();
		this.idPerson = idPerson;
		this.namePerson = namePerson;
	
		this.mailPerson = mailPerson;
		this.dniPerson = dniPerson;
		this.directionPerson = directionPerson;
		
	}


	public int getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}


	public String getNamePerson() {
		return namePerson;
	}


	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}





	public String getMailPerson() {
		return mailPerson;
	}


	public void setMailPerson(String mailPerson) {
		this.mailPerson = mailPerson;
	}


	public int getDniPerson() {
		return dniPerson;
	}


	public void setDniPerson(int dniPerson) {
		this.dniPerson = dniPerson;
	}


	public String getDirectionPerson() {
		return directionPerson;
	}


	public void setDirectionPerson(String directionPerson) {
		this.directionPerson = directionPerson;
	}


	
	
}
