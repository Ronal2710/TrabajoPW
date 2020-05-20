package pe.edu.upc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vouchers")
public class Voucher implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoucher;
	
	private Date dateVoucher;

	public Voucher(int idVoucher, Date dateVoucher) {
		super();
		this.idVoucher = idVoucher;
		this.dateVoucher = dateVoucher;
	}

	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(int idVoucher) {
		this.idVoucher = idVoucher;
	}

	public Date getDateVoucher() {
		return dateVoucher;
	}

	public void setDateVoucher(Date dateVoucher) {
		this.dateVoucher = dateVoucher;
	}

	

}