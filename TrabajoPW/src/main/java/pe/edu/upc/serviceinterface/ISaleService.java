package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Sale;

public interface ISaleService {
	
	public void insert(Sale sale);

	List<Sale> list();

	Optional<Sale> searchId(int idSale);

	public void delete(int idSale);
	
}
