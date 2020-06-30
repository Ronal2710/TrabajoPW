package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.ClassProduct;

@Repository
public interface IClassProductRepository extends JpaRepository<ClassProduct, Integer>{

	@Query("select count(c.nameClassProduct) from ClassProduct c where c.nameClassProduct=LOWER(:nameClassProduct) or c.nameClassProduct=UPPER(:nameClassProduct)")
	public int searchClassProduct(@Param("nameClassProduct")String nombre);

	@Query("select c from ClassProduct c where c.nameClassProduct like ?1%")
	List<ClassProduct> findBynameClassProduct(String nameClassProduct);

}
