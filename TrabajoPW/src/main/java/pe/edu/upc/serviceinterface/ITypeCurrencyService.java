package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.TypeCurrency;

public interface ITypeCurrencyService {

	public int insert(TypeCurrency typecurrency);

	List<TypeCurrency> list();

	public void delete(int idTypeCurrency);

	public List<TypeCurrency> search(String busqueda);

	public Optional<TypeCurrency> searchId(int id);

}
