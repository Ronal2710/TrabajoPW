package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entity.TypeUser;



public interface ITypeUserRepository extends JpaRepository<TypeUser, Integer> {

	@Query("select count(c.nameTypeUser) from TypeUser c where c.nameTypeUser=LOWER(:nameTypeUser) or c.nameTypeUser=UPPER(:nameTypeUser)")
	public int searchTypeUser(@Param("nameTypeUser")String nombre);
}
