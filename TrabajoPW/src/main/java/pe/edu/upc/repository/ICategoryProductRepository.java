package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entity.CategoryProduct;

public interface ICategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {

}
