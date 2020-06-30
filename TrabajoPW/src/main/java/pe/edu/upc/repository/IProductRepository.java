   package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	@Query("select count(p.nameProduct) from Product p where UPPER(p.nameProduct)=:nameProduct or LOWER(p.nameProduct)=:nameProduct")
	public int searchProduct(@Param("nameProduct") String nombre);
	
	@Query("from Product p where p.nameProduct like %:busqueda% or p.brand.nameBrand like %:busqueda% or p.category.nameCategoryProduct like %:busqueda% or p.classproduct.nameClassProduct like %:busqueda%")
	List<Product> search(@Param("busqueda") String busqueda);
	
	@Query( value="SELECT pr.name_product,sum(ide.quantity) from sales i join sale_details ide on  ide.id_sale = i.id_sale join products pr on ide.id_product = pr.id_product group by pr.name_product",
			nativeQuery = true )
	public List<String[]> prodXsale();
	
	@Query( value="SELECT pr.name_product,sum(ide.quantity) from rents i join rent_details ide on  ide.id_rent = i.id_rent join products pr on ide.id_product = pr.id_product group by pr.name_product",
			nativeQuery = true )
	public List<String[]> prodXrent();
}
