package pe.edu.upc.serviceinterface;

import java.util.List;



import pe.edu.upc.entity.Rent;

public interface IRentService {

	
	public boolean insert(Rent rent);

	Rent listarId(long id);

	List<Rent> listar();


}
