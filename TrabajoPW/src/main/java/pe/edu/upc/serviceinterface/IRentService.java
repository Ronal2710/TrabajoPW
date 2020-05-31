package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Rent;

public interface IRentService {
	public int insert(Rent rent);
	List<Rent> list();
}
