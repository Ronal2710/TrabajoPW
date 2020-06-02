package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.TypeCard;

public interface ITypeCardService {
	
	public int insert(TypeCard typeCard);
	List<TypeCard> list();
	
}
