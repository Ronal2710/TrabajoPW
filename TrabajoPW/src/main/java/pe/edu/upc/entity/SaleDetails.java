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
@Table(name = "saleDetails")
public class SaleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSaleDetails;
	
	@ManyToOne
	@JoinColumn(name = "idProduct", nullable = false)
	private Product product;

	@Positive(message = "La cantidad debe de ser positivo")
	@Column(name = "quantity", nullable = false)
	private int quantity;

	public Double calcularSubTotal() {
		return quantity * product.getPriceProduct();
	}

	public Long getIdSaleDetails() {
		return idSaleDetails;
	}

	public void setIdSaleDetails(Long idSaleDetails) {
		this.idSaleDetails = idSaleDetails;
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
