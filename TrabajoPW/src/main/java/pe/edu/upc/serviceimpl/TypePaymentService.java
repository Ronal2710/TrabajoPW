package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypePayment;
import pe.edu.upc.repository.ITypePaymentRepository;
import pe.edu.upc.serviceinterface.ITypePaymentService;

@Service
public class TypePaymentService implements ITypePaymentService{
	
	@Autowired
	private ITypePaymentRepository pR;
	@Override
	public void insert(TypePayment typePayment) {
		pR.save(typePayment);
		
	}

	@Override
	public List<TypePayment> list() {
		// TODO Auto-generated method stub
		return pR.findAll();	
	}
	

}
