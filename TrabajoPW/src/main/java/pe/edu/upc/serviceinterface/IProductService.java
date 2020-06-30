package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Product;

public interface IProductService {
	public int insert(Product product);

	List<Product> list();

	Optional<Product> searchId(int idProduct);

	public List<Product> search(String busqueda);
	
	public void delete(int idProduct);
	
	public List<String[]> prodXsale();
	
	public List<String[]> prodXrent();
}
