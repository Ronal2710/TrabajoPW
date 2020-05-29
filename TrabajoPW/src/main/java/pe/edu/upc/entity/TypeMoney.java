package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typemoneys")
public class TypeMoney implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeMoney;
	@Column(name = "nameTypeMoney", length = 80, nullable = false)
	private String nameTypeMoney;

	public TypeMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeMoney(int idTypeMoney, String nameTypeMoney) {
		super();
		this.idTypeMoney = idTypeMoney;
		this.nameTypeMoney = nameTypeMoney;
	}

	public int getIdTypeMoney() {
		return idTypeMoney;
	}

	public void setIdTypeMoney(int idTypeMoney) {
		this.idTypeMoney = idTypeMoney;
	}

	public String getNameTypeMoney() {
		return nameTypeMoney;
	}

	public void setNameTypeMoney(String nameTypeMoney) {
		this.nameTypeMoney = nameTypeMoney;
	}

}