package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	@Column(name = "nameProduct", nullable = false, length = 30)
	private String nameProduct;
	@Column(name = "quantityProduct", nullable = false)
	private int quantityProduct;
	@Column(name = "descriptionProduct", nullable = false)
	private String descriptionProduct;
	@Column(name = "imageProduct", nullable = false)
	private String imageProduct;
	@Column(name = "priceProduct", nullable = false)
	private float priceProduct;
	
	@ManyToOne
	@JoinColumn(name="idCategoryProduct")
	private CategoryProduct category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Product(int idProduct, String nameProduct, int quantityProduct, String descriptionProduct,
			String imageProduct, float priceProduct, CategoryProduct category) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantityProduct = quantityProduct;
		this.descriptionProduct = descriptionProduct;
		this.imageProduct = imageProduct;
		this.priceProduct = priceProduct;
		this.category = category;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public String getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}

	
}
