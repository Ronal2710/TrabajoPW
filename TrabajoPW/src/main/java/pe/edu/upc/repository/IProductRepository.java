 package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	@Query("select count(c.nameProduct) from Product c where c.nameProduct=LOWER(:nameProduct) or c.nameProduct=UPPER(:nameProduct)")
	public int searchProduct(@Param("nameProduct")String nombre);
}
