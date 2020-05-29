package pe.edu.upc.serviceinterface;

import java.util.List;


import pe.edu.upc.entity.TypeUser;

public interface ITypeUserService {

	public void insert(TypeUser typeUser);
	List<TypeUser> list();
}
