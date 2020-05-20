package pe.edu.upc.entity;

public class CategoryProduct {

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
