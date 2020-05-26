package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSale;
	
	private int amountSale;
	private int quantitySale;
	private int dateSale;
	
	public Sale(int idSale, int amountSale, int quantitySale, int dateSale) {
		super();
		this.idSale = idSale;
		this.amountSale = amountSale;
		this.quantitySale = quantitySale;
		this.dateSale = dateSale;
	}
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdSale() {
		return idSale;
	}
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public int getAmountSale() {
		return amountSale;
	}
	public void setAmountSale(int amountSale) {
		this.amountSale = amountSale;
	}
	public int getQuantitySale() {
		return quantitySale;
	}
	public void setQuantitySale(int quantitySale) {
		this.quantitySale = quantitySale;
	}
	public int getDateSale() {
		return dateSale;
	}
	public void setDateSale(int dateSale) {
		this.dateSale = dateSale;
	}

	
}