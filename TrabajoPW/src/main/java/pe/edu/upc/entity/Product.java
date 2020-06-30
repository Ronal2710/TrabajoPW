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
import javax.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product implements Serializable{

	/**
	 * 
	 */
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
	@Positive
	@Column(name = "priceProduct", columnDefinition = "Decimal(8,2)", nullable = false)
	private Double priceProduct;

	@ManyToOne
	@JoinColumn(name = "idBrand")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "idClassProduct")
	private ClassProduct classproduct;
	
	@ManyToOne
	@JoinColumn(name = "idCategoryProduct")
	private CategoryProduct category;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	private String foto;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int idProduct, String nameProduct, int quantityProduct, String descriptionProduct,
			@Positive Double priceProduct, Brand brand, ClassProduct classproduct, CategoryProduct category, User user,
			String foto) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantityProduct = quantityProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.brand = brand;
		this.classproduct = classproduct;
		this.category = category;
		this.user = user;
		this.foto = foto;
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

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ClassProduct getClassproduct() {
		return classproduct;
	}

	public void setClassproduct(ClassProduct classproduct) {
		this.classproduct = classproduct;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
