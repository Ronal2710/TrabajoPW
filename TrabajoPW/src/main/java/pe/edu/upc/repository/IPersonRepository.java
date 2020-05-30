package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
 

}
