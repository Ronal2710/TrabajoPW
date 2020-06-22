package pe.edu.upc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.CategoryProduct;


@Repository
public interface ICategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {
	@Query("select count(c.nameCategoryProduct) from CategoryProduct c where c.nameCategoryProduct=LOWER(:nameCategoryProduct) or c.nameCategoryProduct=UPPER(:nameCategoryProduct)")
	public int searchCategory(@Param("nameCategoryProduct")String nombre);
	
	@Query("select c from CategoryProduct c where c.nameCategoryProduct like ?1%")
	List<CategoryProduct> findBynameCategoryProduct(String nameCategoryProduct);
	

}
