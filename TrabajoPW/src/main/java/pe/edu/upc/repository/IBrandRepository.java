package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer>{
	@Query("select count(c.nameBrand) from Brand c where c.nameBrand=LOWER(:nameBrand) or c.nameBrand=UPPER(:nameBrand)")
	public int searchBrand(@Param("nameBrand")String nombre);
	
	@Query("select c from Brand c where c.nameBrand like ?1%")
	List<Brand> findBynameBrand(String nameBrand);
}
