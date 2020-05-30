package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.TypeCurrency;

public interface ITypeCurrencyService {
	
	public void insert(TypeCurrency typecurrency);
	List<TypeCurrency> list();
}
