package pe.edu.upc.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSale;

	@Column(name = "requestDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;// cuando se pidio

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idSale", nullable = true)
	private List<SaleDetails> saleDetails;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	@PrePersist
	public void prePersist() {
		this.requestDate = new Date();
	}

	public Double getTotal() {
		return saleDetails.stream().collect(Collectors.summingDouble(SaleDetails::calcularSubTotal));
	}

	public void addDetailSaleation(SaleDetails item) {
		this.saleDetails.add(item);
	}

	public long getIdSale() {
		return idSale;
	}

	public void setIdSale(long idSale) {
		this.idSale = idSale;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public List<SaleDetails> getSaleDetails() {
		return saleDetails;
	}

	public void setSaleDetails(List<SaleDetails> SaleDetails) {
		this.saleDetails = SaleDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
