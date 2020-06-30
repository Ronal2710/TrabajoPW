package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.ClassProduct;

public interface IClassProductService {
	
	public int insert(ClassProduct classProduct);

	List<ClassProduct> list();

	public void delete(int idClassProduct);

	List<ClassProduct> findNameClassProductFull(String nameClassProduct);

	Optional<ClassProduct> searchId(int idClassProduct);
}
