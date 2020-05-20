package pe.edu.upc.entity;

import java.io.Serializable;

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
	private String nameCategoryProduct;
	private String descriptionCategoryProduct;

	
	
	
	public CategoryProduct(int idCategoryProduct, String nameCategoryProduct, String descriptionCategoryProduct) {
		super();
		this.idCategoryProduct = idCategoryProduct;
		this.nameCategoryProduct = nameCategoryProduct;
		this.descriptionCategoryProduct = descriptionCategoryProduct;
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
	public String getDescriptionCategoryProduct() {
		return descriptionCategoryProduct;
	}
	public void setDescriptionCategoryProduct(String descriptionCategoryProduct) {
		this.descriptionCategoryProduct = descriptionCategoryProduct;
	}
	
	
}
