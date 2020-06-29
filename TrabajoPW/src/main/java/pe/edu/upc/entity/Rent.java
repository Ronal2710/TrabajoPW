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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "rents")
public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRent;

	@Column(name = "registerRent")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerRent;

	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Column(name = "startdateRent")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdateRent;

	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Column(name = "enddateRent")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddateRent;

	@Positive
	@Column(name = "quantityRent", nullable = false)
	private int quantityRent;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	public Double calcularMontoTotal() {
		Double b;
		b = (double) quantityRent;
		
		return b*product.getPriceProduct();
	}

	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}

		

	public Rent(int idRent, Date registerRent,
			@NotNull(message = "La fecha es obligatoria") @Future(message = "La fecha debe estar en el futuro") Date startdateRent,
			@NotNull(message = "La fecha es obligatoria") @Future(message = "La fecha debe estar en el futuro") Date enddateRent,
			@Positive int quantityRent, Product product, User user) {
		super();
		this.idRent = idRent;
		this.registerRent = registerRent;
		this.startdateRent = startdateRent;
		this.enddateRent = enddateRent;
		this.quantityRent = quantityRent;
		this.product = product;
		this.user = user;
	}



	@PrePersist
	public void prePersist() {
		this.registerRent = new Date();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIdRent() {
		return idRent;
	}

	public void setIdRent(int idRent) {
		this.idRent = idRent;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
