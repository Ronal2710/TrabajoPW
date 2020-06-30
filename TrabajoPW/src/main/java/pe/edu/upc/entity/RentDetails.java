package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "rentDetails")
public class RentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRentDetails;



	
	@ManyToOne
	@JoinColumn(name = "idProduct", nullable = false)
	private Product product;

	@Positive(message = "El monto debe de ser positivo")
	@Column(name = "quantity", nullable = false)
	private int quantity;

	public Double calcularSubTotal() {
		return quantity * product.getPriceProduct();
	}

	public Long getIdRentDetails() {
		return idRentDetails;
	}

	public void setIdRentDetails(Long idRentDetails) {
		this.idRentDetails = idRentDetails;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
