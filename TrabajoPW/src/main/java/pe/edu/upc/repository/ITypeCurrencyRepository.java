package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.TypeCurrency;

@Repository
public interface ITypeCurrencyRepository extends JpaRepository<TypeCurrency, Integer>{
	@Query("select count(c.nameTypeCurrency) from TypeCurrency c where c.nameTypeCurrency=LOWER(:nameTypeCurrency) or c.nameTypeCurrency=UPPER(:nameTypeCurrency)")
	public int searchTypeCurrency(@Param("nameTypeCurrency")String nombre);
	
	@Query("from TypeCurrency p where p.nameTypeCurrency like %:busqueda%")
	List<TypeCurrency> search(@Param("busqueda") String busqueda);
	
}
