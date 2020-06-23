//package pe.edu.upc.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "typeproduct")
//public class TypeProduct implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int idTypeProduct;
//	
//	@Column(name = "nameTypeProduct", length = 80, nullable = false)
//	private String nameTypeProduct;
//	
//	public TypeProduct() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public TypeProduct(int idTypeProduct, String nameTypeProduct) {
//		super();
//		this.idTypeProduct = idTypeProduct;
//		this.nameTypeProduct = nameTypeProduct;
//	}
//
//	public int getIdTypeProduct() {
//		return idTypeProduct;
//	}
//
//	public void setIdTypeProduct(int idTypeProduct) {
//		this.idTypeProduct = idTypeProduct;
//	}
//
//	public String getNameTypeProduct() {
//		return nameTypeProduct;
//	}
//
//	public void setNameTypeProduct(String nameTypeProduct) {
//		this.nameTypeProduct = nameTypeProduct;
//	}
//
//	
//
//
//}
