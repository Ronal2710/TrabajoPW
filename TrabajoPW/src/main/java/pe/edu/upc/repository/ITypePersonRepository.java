package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import pe.edu.upc.entity.TypePerson;

public interface ITypePersonRepository extends JpaRepository<TypePerson, Integer>{

}
