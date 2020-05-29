package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.TypePayment;

public interface ITypePaymentService {
	
	public void insert(TypePayment typePayment);
	List<TypePayment> list();
}
