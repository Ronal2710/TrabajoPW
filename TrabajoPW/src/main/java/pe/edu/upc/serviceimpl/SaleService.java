package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Sale;
import pe.edu.upc.repository.ISaleRepository;
import pe.edu.upc.serviceinterface.ISaleService;

@Service
public class SaleService implements ISaleService {
	
	@Autowired
	private ISaleRepository sR;
	
	@Transactional
	@Override
	public void insert(Sale sale) {
		// TODO Auto-generated method stub
		sR.save(sale);
		
	}

	@Override
	public List<Sale> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

}
