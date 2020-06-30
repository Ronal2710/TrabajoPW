package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Sale;
import pe.edu.upc.repository.ISaleRepository;
import pe.edu.upc.serviceinterface.ISaleService;


@Service
public class SaleService implements ISaleService{

	@Autowired
	private ISaleRepository sR;
	
	@Override
	public boolean insert(Sale Sale) {
		Sale imp = sR.save(Sale);
		if (imp == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public Sale listarId(long id) {
		Optional<Sale> op = sR.findById(id);
		return op.isPresent() ? op.get() : new Sale();
	}

	@Override
	public List<Sale> listar() {
		return sR.findAll();
	}

	
}
