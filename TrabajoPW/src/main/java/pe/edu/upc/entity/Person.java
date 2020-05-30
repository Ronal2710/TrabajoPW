package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerson;
	
	private String namePerson;
	private String lastnamePerson;
	private String mailPerson;
	private int dniPerson;
	private String directionPerson;
	private String userPerson;
	private String passwordPerson;
	
	@OneToOne
	@JoinColumn(name="idTypeUser")
	private TypeUser typeUser;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(int idPerson, String namePerson, String lastnamePerson, String mailPerson, int dniPerson,
			String directionPerson, String userPerson, String passwordPerson, TypeUser typeUser) {
		super();
		this.idPerson = idPerson;
		this.namePerson = namePerson;
		this.lastnamePerson = lastnamePerson;
		this.mailPerson = mailPerson;
		this.dniPerson = dniPerson;
		this.directionPerson = directionPerson;
		this.userPerson = userPerson;
		this.passwordPerson = passwordPerson;
		this.typeUser = typeUser;
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


	public String getLastnamePerson() {
		return lastnamePerson;
	}


	public void setLastnamePerson(String lastnamePerson) {
		this.lastnamePerson = lastnamePerson;
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


	public String getUserPerson() {
		return userPerson;
	}


	public void setUserPerson(String userPerson) {
		this.userPerson = userPerson;
	}


	public String getPasswordPerson() {
		return passwordPerson;
	}


	public void setPasswordPerson(String passwordPerson) {
		this.passwordPerson = passwordPerson;
	}


	public TypeUser getTypeUser() {
		return typeUser;
	}


	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	
	
}
