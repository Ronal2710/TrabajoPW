package pe.edu.upc.serviceinterface;

import pe.edu.upc.entity.RentDetails;


public interface IRentDetailsService {

	public Integer insert(RentDetails rd);

	public void delete(long idRentDetail);
}
