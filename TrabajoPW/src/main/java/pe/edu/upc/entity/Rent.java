package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rents")
public class Rent implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRent;
	@Column(name = "registerdateRent", nullable = false)
	private String registerdateRent;
	@Column(name = "startdateRent", nullable = false)
	private String startdateRent;
	@Column(name = "enddateRent", nullable = false)
	private String enddateRent;
	@Column(name = "quantityRent", nullable = false)
	private int quantityRent;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	
	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rent(int idRent, String registerdateRent, String startdateRent, String enddateRent, int quantityRent,
			Product product) {
		super();
		this.idRent = idRent;
		this.registerdateRent = registerdateRent;
		this.startdateRent = startdateRent;
		this.enddateRent = enddateRent;
		this.quantityRent = quantityRent;
		this.product = product;
	}

	public int getIdRent() {
		return idRent;
	}

	public void setIdRent(int idRent) {
		this.idRent = idRent;
	}

	public String getRegisterdateRent() {
		return registerdateRent;
	}

	public void setRegisterdateRent(String registerdateRent) {
		this.registerdateRent = registerdateRent;
	}

	public String getStartdateRent() {
		return startdateRent;
	}

	public void setStartdateRent(String startdateRent) {
		this.startdateRent = startdateRent;
	}

	public String getEnddateRent() {
		return enddateRent;
	}

	public void setEnddateRent(String enddateRent) {
		this.enddateRent = enddateRent;
	}

	public int getQuantityRent() {
		return quantityRent;
	}

	public void setQuantityRent(int quantityRent) {
		this.quantityRent = quantityRent;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
