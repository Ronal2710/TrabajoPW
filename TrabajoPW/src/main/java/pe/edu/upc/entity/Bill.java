package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "bills")
public class Bill implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBill;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateBill;
	
	@ManyToOne
	@JoinColumn(name="idTypeCard")
	private TypeCard typeCard;
	
	@ManyToOne
	@JoinColumn(name="idTypeCurrency")
	private TypeCurrency typeCurrency;
	
	@ManyToOne
	@JoinColumn(name="idTypePayment")
	private TypePayment typePayment;
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idRent")
	private Rent rent;
	
	@ManyToOne
	@JoinColumn(name="idSale")
	private Sale sale;
	
	

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

























	public Bill(int idBill, Date dateBill, TypeCard typeCard, TypeCurrency typeCurrency, TypePayment typePayment,
			User user, Rent rent, Sale sale) {
		super();
		this.idBill = idBill;
		this.dateBill = dateBill;
		this.typeCard = typeCard;
		this.typeCurrency = typeCurrency;
		this.typePayment = typePayment;
		this.user = user;
		this.rent = rent;
		this.sale = sale;
	}

























	public User getUser() {
		return user;
	}







	public void setUser(User user) {
		this.user = user;
	}







	public int getIdBill() {
		return idBill;
	}



	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}






	public Date getDateBill() {
		return dateBill;
	}



	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}



	public TypeCard getTypeCard() {
		return typeCard;
	}



	public void setTypeCard(TypeCard typeCard) {
		this.typeCard = typeCard;
	}



	public TypeCurrency getTypeCurrency() {
		return typeCurrency;
	}



	public void setTypeCurrency(TypeCurrency typeCurrency) {
		this.typeCurrency = typeCurrency;
	}



	public TypePayment getTypePayment() {
		return typePayment;
	}



	public void setTypePayment(TypePayment typePayment) {
		this.typePayment = typePayment;
	}












	public Rent getRent() {
		return rent;
	}












	public void setRent(Rent rent) {
		this.rent = rent;
	}












	public Sale getSale() {
		return sale;
	}












	public void setSale(Sale sale) {
		this.sale = sale;
	}

	
}