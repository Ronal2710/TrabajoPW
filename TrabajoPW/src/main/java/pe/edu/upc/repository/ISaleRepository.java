package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Sale;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Integer> {
	
}
