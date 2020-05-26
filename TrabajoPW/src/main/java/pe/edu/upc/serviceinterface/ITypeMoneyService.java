package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.TypeMoney;

public interface ITypeMoneyService {
	
	public void insert(TypeMoney typeMoney);
	List<TypeMoney> list();
}
