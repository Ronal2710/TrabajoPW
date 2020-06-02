package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Bill;




public interface IBillService {

	public void insert(Bill Bill);
	List<Bill> list();
}

