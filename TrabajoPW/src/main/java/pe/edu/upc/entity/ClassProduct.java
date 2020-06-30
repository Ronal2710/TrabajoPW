package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classproduct")
public class ClassProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClassProduct;
	@Column(name = "nameClassProduct", length = 80, nullable = false)
	private String nameClassProduct;
	public ClassProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassProduct(int idClassProduct, String nameClassProduct) {
		super();
		this.idClassProduct = idClassProduct;
		this.nameClassProduct = nameClassProduct;
	}
	public int getIdClassProduct() {
		return idClassProduct;
	}
	public void setIdClassProduct(int idClassProduct) {
		this.idClassProduct = idClassProduct;
	}
	public String getNameClassProduct() {
		return nameClassProduct;
	}
	public void setNameClassProduct(String nameClassProduct) {
		this.nameClassProduct = nameClassProduct;
	}
	
	
}
