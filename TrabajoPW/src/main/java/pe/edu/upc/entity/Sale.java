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
@Table(name = "sales")
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSale;
	@Column(name = "amountSale", nullable = false)
	private float amountSale;
	@Column(name = "quantitySale", nullable = false)
	private int quantitySale;
	@Column(name = "dateSale", nullable = false)
	private String dateSale;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(int idSale, float amountSale, int quantitySale, String dateSale, Product product) {
		super();
		this.idSale = idSale;
		this.amountSale = amountSale;
		this.quantitySale = quantitySale;
		this.dateSale = dateSale;
		this.product = product;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public float getAmountSale() {
		return amountSale;
	}

	public void setAmountSale(float amountSale) {
		this.amountSale = amountSale;
	}

	public int getQuantitySale() {
		return quantitySale;
	}

	public void setQuantitySale(int quantitySale) {
		this.quantitySale = quantitySale;
	}

	public String getDateSale() {
		return dateSale;
	}

	public void setDateSale(String dateSale) {
		this.dateSale = dateSale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}