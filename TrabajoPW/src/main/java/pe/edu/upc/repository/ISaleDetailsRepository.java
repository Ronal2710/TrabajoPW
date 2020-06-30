package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.SaleDetails;

@Service
public interface ISaleDetailsRepository  extends JpaRepository<SaleDetails, Long>{

}
