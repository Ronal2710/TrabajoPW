package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typecurrency")
public class TypeCurrency implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeCurrency;
	@Column(name = "nameTypeCurrency", length = 80, nullable = false)
	private String nameTypeCurrency;
	public TypeCurrency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeCurrency(int idTypeCurrency, String nameTypeCurrency) {
		super();
		this.idTypeCurrency = idTypeCurrency;
		this.nameTypeCurrency = nameTypeCurrency;
	}
	public int getIdTypeCurrency() {
		return idTypeCurrency;
	}
	public void setIdTypeCurrency(int idTypeCurrency) {
		this.idTypeCurrency = idTypeCurrency;
	}
	public String getNameTypeCurrency() {
		return nameTypeCurrency;
	}
	public void setNameTypeCurrency(String nameTypeCurrency) {
		this.nameTypeCurrency = nameTypeCurrency;
	}

	

}