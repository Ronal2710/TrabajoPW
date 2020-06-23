package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.TypePayment;

public interface ITypePaymentService {

	public int insert(TypePayment typePayment);

	List<TypePayment> list();

	public void delete(int idTypePayment);

	public Optional<TypePayment> searchId(int id);

	public List<TypePayment> search(String busqueda);
	
}
