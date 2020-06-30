package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sales")
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSale;
	@Positive
	@Column(name = "quantitySale", nullable = false)
	private int quantitySale;
	@Column(name = "dateSale")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSale;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	public Double montototal() {
		Double c;
		c= (double) quantitySale;

		return c*product.getPriceProduct();
	}
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;

	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(int idSale, @Positive int quantitySale, Date dateSale, Product product, User user) {
		super();
		this.idSale = idSale;
		this.quantitySale = quantitySale;
		this.dateSale = dateSale;
		this.product = product;
		this.user = user;
	}
	
	@PrePersist
	public void presPersist() {
		this.dateSale= new Date();
	}
	
	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public int getQuantitySale() {
		return quantitySale;
	}

	public void setQuantitySale(int quantitySale) {
		this.quantitySale = quantitySale;
	}

	public Date getDateSale() {
		return dateSale;
	}

	public void setDateSale(Date dateSale) {
		this.dateSale = dateSale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}