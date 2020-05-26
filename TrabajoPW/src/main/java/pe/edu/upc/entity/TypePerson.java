package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class TypePerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypePerson;
	@Column(name = "nameTypePerson", length = 80, nullable = false)
	private String nameTypePerson;
	
	
	
	public TypePerson() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TypePerson(int idTypePerson, String nameTypePerson) {
		super();
		this.idTypePerson = idTypePerson;
		this.nameTypePerson = nameTypePerson;
	}



	public int getIdTypePerson() {
		return idTypePerson;
	}



	public void setIdTypePerson(int idTypePerson) {
		this.idTypePerson = idTypePerson;
	}



	public String getNameTypePerson() {
		return nameTypePerson;
	}



	public void setNameTypePerson(String nameTypePerson) {
		this.nameTypePerson = nameTypePerson;
	}
	
	
	
	

}
