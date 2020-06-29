package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.CategoryProduct;
import pe.edu.upc.entity.TypePayment;

@Repository
public interface ITypePaymentRepository extends JpaRepository<TypePayment, Integer>{
	
	@Query("select count(c.nameTypePayment) from TypePayment c where c.nameTypePayment=LOWER(:nameTypePayment) or c.nameTypePayment=UPPER(:nameTypePayment)")
	public int searchTypePayment(@Param("nameTypePayment")String nombre);
	
	@Query("select c from TypePayment c where c.nameTypePayment like ?1%")
	List<TypePayment> findBynameTypePayment(String nameTypePayment);
	
}
