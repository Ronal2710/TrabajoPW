package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import pe.edu.upc.entity.Rent;

public interface IRentRepository extends JpaRepository<Rent, Integer> {
	
//	@Query("select count(c.nameRent) from Rent c where c.nameRent=LOWER(:nameRent) or c.nameRent=UPPER(:nameRent)")
//	public int searchRent(@Param("nameRent")String nombre);
}
