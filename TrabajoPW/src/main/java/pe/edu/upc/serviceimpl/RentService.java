package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Rent;
import pe.edu.upc.repository.IRentRepository;
import pe.edu.upc.serviceinterface.IRentService;


@Service
public class RentService implements IRentService{

	@Autowired
	private IRentRepository rR;
	
	@Override
	public boolean insert(Rent rent) {
		Rent imp = rR.save(rent);
		if (imp == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public Rent listarId(long id) {
		Optional<Rent> op = rR.findById(id);
		return op.isPresent() ? op.get() : new Rent();
	}

	@Override
	public List<Rent> listar() {
		return rR.findAll();
	}

	
}
