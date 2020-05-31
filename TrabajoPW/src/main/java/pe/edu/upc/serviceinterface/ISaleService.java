package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Sale;

public interface ISaleService {
	public int insert(Sale sale);
	List<Sale> list();
}
