package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.SaleDetails;

import pe.edu.upc.repository.ISaleDetailsRepository;
import pe.edu.upc.serviceinterface.ISaleDetailsService;




@Service
public class SaleDetailsService implements ISaleDetailsService{

	@Autowired
	private ISaleDetailsRepository idsR;

	@Override
	public void delete(long id) {
		idsR.deleteById(id);
	}

	@Override
	public Integer insert(SaleDetails impd) {
		SaleDetails impde = idsR.save(impd);
		if (impde == null) {
			return 0;
		} else {
			return 1;
		}
	}

}
