package pe.edu.upc.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.Rent;
@Repository
public interface IRentRepository extends JpaRepository<Rent, Long>{

	

}
