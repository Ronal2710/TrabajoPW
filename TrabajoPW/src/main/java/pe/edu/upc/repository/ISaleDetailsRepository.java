package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.SaleDetails;

public interface ISaleDetailsRepository  extends JpaRepository<SaleDetails, Long>{

}
