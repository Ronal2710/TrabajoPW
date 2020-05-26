package pe.edu.upc.serviceinterface;

import java.util.List;


import pe.edu.upc.entity.TypePerson;

public interface ITypePersonService {
	
	public void insert(TypePerson typePerson);
	List<TypePerson> list();


}
