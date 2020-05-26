package pe.edu.upc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rents")
public class Rent implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRent;
	
	private float amountRent;
	private Date registerRent;
	private Date startdateRent;
	private Date enddateRent;
	private int quantityRent;
	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rent(int idRent, float amountRent, Date registerRent, Date startdateRent, Date enddateRent, int quantityRent) {
		super();
		this.idRent = idRent;
		this.amountRent = amountRent;
		this.registerRent = registerRent;
		this.startdateRent = startdateRent;
		this.enddateRent = enddateRent;
		this.quantityRent = quantityRent;
	}
	public int getIdRent() {
		return idRent;
	}
	public void setIdRent(int idRent) {
		this.idRent = idRent;
	}
	public float getAmountRent() {
		return amountRent;
	}
	public void setAmountRent(int amountRent) {
		this.amountRent = amountRent;
	}
	public Date getRegisterRent() {
		return registerRent;
	}
	public void setRegisterRent(Date registerRent) {
		this.registerRent = registerRent;
	}
	public Date getStartdateRent() {
		return startdateRent;
	}
	public void setStartdateRent(Date startdateRent) {
		this.startdateRent = startdateRent;
	}
	public Date getEnddateRent() {
		return enddateRent;
	}
	public void setEnddateRent(Date enddateRent) {
		this.enddateRent = enddateRent;
	}
	public int getQuantityRent() {
		return quantityRent;
	}
	public void setQuantityRent(int quantityRent) {
		this.quantityRent = quantityRent;
	}
	
	

}
