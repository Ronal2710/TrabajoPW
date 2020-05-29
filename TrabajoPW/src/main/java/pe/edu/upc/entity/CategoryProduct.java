package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoryProduct;
	@Column(name = "nameCategoryProduct", length = 80, nullable = false)
	private String nameCategoryProduct;

	
	public CategoryProduct(int idCategoryProduct, String nameCategoryProduct) {
		super();
		this.idCategoryProduct = idCategoryProduct;
		this.nameCategoryProduct = nameCategoryProduct;
		
	}
	
	public CategoryProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCategoryProduct() {
		return idCategoryProduct;
	}
	
	public void setIdCategoryProduct(int idCategoryProduct) {
		this.idCategoryProduct = idCategoryProduct;
	}
	public String getNameCategoryProduct() {
		return nameCategoryProduct;
	}
	public void setNameCategoryProduct(String nameCategoryProduct) {
		this.nameCategoryProduct = nameCategoryProduct;
	}

}
