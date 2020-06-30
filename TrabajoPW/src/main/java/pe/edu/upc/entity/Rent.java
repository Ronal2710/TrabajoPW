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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "rents")
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRent;

	@Column(name = "requestDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;// cuando se pidio
	
	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Column(name = "startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Column(name = "endDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idRent", nullable = true)
	private List<RentDetails> rentDetails;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	@PrePersist
	public void prePersist() {
		this.requestDate = new Date();
	}

	public Double getTotal() {
		return rentDetails.stream().collect(Collectors.summingDouble(RentDetails::calcularSubTotal));
	}

	public void addDetailRentation(RentDetails item) {
		this.rentDetails.add(item);
	}

	public long getIdRent() {
		return idRent;
	}

	public void setIdRent(long idRent) {
		this.idRent = idRent;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public List<RentDetails> getRentDetails() {
		return rentDetails;
	}

	public void setRentDetails(List<RentDetails> RentDetails) {
		this.rentDetails = RentDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
