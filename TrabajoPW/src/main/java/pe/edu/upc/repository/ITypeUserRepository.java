package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.TypeUser;



public interface ITypeUserRepository extends JpaRepository<TypeUser, Integer> {

}
