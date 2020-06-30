package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Sale;

public interface ISaleService {

	
	public boolean insert(Sale Sale);

	Sale listarId(long id);

	List<Sale> listar();

//	Optional<Sale> fetchBySaleIdWhithSaleDetailsWithProduct(Long id);
}
