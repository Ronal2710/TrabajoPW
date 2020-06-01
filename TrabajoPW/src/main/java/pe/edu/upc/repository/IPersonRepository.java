package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
	@Query("select count(c.dniPerson) from Person c where c.dniPerson=:dniPerson ")
	public int searchPerson(@Param("dniPerson")int dni);

}
