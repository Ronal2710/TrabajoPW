package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.TypeCard;

public interface ITypeCardService {

	public int insert(TypeCard typeCard);

	List<TypeCard> list();

	public void delete(int idTypeCard);

	Optional<TypeCard> searchId(int idTypeCard);
}
