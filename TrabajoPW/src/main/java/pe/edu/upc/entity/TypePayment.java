package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typepayments")
public class TypePayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypePayment;
	@Column(name = "nameTypePayment", length = 80, nullable = false)
	private String nameTypePayment;
	public TypePayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypePayment(int idTypePayment, String nameTypePayment) {
		super();
		this.idTypePayment = idTypePayment;
		this.nameTypePayment = nameTypePayment;
	}
	public int getIdTypePayment() {
		return idTypePayment;
	}
	public void setIdTypePayment(int idTypePayment) {
		this.idTypePayment = idTypePayment;
	}
	public String getNameTypePayment() {
		return nameTypePayment;
	}
	public void setNameTypePayment(String nameTypePayment) {
		this.nameTypePayment = nameTypePayment;
	}
	
	
}
