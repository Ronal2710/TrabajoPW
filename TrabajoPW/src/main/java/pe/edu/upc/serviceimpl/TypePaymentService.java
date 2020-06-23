package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypePayment;
import pe.edu.upc.repository.ITypePaymentRepository;
import pe.edu.upc.serviceinterface.ITypePaymentService;

@Service
public class TypePaymentService implements ITypePaymentService{
	
	@Autowired
	private ITypePaymentRepository pR;
	
	@Transactional
	@Override
	public int insert(TypePayment typePayment) {
		int rpta=pR.searchTypePayment(typePayment.getNameTypePayment());
		if(rpta==0)
		{
			pR.save(typePayment);
		}
		return rpta;
		
	}

	@Override
	public List<TypePayment> list() {
		// TODO Auto-generated method stub
		return pR.findAll();	
	}
	

}
