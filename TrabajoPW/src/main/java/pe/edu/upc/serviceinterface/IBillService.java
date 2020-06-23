package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Bill;





public interface IBillService {

	public void insert(Bill Bill);
	List<Bill> list();
	Optional<Bill> searchId(int idBill);
}

