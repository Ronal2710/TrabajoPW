package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Rent;

public interface IRentService {
	public void insert(Rent rent);

	List<Rent> list();
	
	Optional<Rent> searchId(int idRent);
	
	public void delete(int idRent);
}
