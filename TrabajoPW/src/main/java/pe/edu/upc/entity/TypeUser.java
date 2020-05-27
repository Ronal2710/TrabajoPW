package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeusers")
public class TypeUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeUser;
	@Column(name = "nameTypeUser", length = 80, nullable = false)
	private String nameTypeUser;


	
	
	
	public TypeUser(int idTypeUser, String nameTypeUser) {
		super();
		this.idTypeUser = idTypeUser;
		this.nameTypeUser = nameTypeUser;
		
	}
	
	public TypeUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdTypeUser() {
		return idTypeUser;
	}
	
	public void setIdTypeUser(int idTypeUser) {
		this.idTypeUser = idTypeUser;
	}
	public String getNameTypeUser() {
		return nameTypeUser;
	}
	public void setNameTypeUser(String nameTypeUser) {
		this.nameTypeUser = nameTypeUser;
	}

}
