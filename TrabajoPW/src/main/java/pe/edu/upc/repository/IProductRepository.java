   package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	@Query("select count(p.nameProduct) from Product p where UPPER(p.nameProduct)=:nameProduct or LOWER(p.nameProduct)=:nameProduct")
	public int searchProduct(@Param("nameProduct") String nombre);
	
	@Query("from Product p where p.nameProduct like %:busqueda% or p.brand.nameBrand like %:busqueda% or p.category.nameCategoryProduct like %:busqueda% or p.classproduct.nameClassProduct like %:busqueda%")
	List<Product> search(@Param("busqueda") String busqueda);
}
