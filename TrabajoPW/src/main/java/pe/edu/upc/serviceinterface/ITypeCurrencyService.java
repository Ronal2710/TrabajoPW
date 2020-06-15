package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.TypeCurrency;

public interface ITypeCurrencyService {
	
	public int insert(TypeCurrency typecurrency);
	List<TypeCurrency> list();
}
