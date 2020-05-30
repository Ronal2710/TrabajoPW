package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.TypeCurrency;

public interface ITypeCurrencyRepository extends JpaRepository<TypeCurrency, Integer>{
	
}
