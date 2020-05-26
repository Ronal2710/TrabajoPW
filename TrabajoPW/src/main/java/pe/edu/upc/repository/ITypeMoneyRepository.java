package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.TypeMoney;

public interface ITypeMoneyRepository extends JpaRepository<TypeMoney, Integer>{
	
}
