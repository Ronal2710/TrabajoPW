package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Rol;

public interface IRolService {
	public void insert(Rol role);

	List<Rol> list();
	public void delete(long id);
}
