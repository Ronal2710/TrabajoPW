package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.CategoryProduct;

public interface ICategoryProductService {

	public int insert(CategoryProduct categoryProduct);

	List<CategoryProduct> list();

	public void delete(int idCategoryProduct);

	List<CategoryProduct> findNameCategoryProductFull(String nameCategory);

	Optional<CategoryProduct> searchId(int idCategoryProduct);

}
