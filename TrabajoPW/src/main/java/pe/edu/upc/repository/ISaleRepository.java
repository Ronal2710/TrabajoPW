package pe.edu.upc.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.Sale;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
	
//	@Query("select i from sales i join fetch i.saleDetails ide join fetch ide.products where i.idSale=?1")
//	Optional<Sale> fetchBySaleIdWhithSaleDetailsWithProduct(Long id);

}
