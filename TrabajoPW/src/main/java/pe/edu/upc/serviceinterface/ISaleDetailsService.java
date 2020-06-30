package pe.edu.upc.serviceinterface;

import pe.edu.upc.entity.SaleDetails;


public interface ISaleDetailsService {

	public Integer insert(SaleDetails rd);

	public void delete(long idSaleDetail);
}
