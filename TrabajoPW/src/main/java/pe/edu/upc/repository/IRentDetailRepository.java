package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.RentDetails;

public interface IRentDetailRepository  extends JpaRepository<RentDetails, Long>{

}
