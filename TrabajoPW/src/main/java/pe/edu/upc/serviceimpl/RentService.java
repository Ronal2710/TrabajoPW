package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Rent;
import pe.edu.upc.repository.IRentRepository;
import pe.edu.upc.serviceinterface.IRentService;

@Service
public class RentService implements IRentService{

	@Autowired
	private IRentRepository rR;
	
	@Transactional
	@Override
	public void insert(Rent rent) {
		// TODO Auto-generated method stub
		rR.save(rent);
	}

	@Override
	public List<Rent> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

	@Override
	public Optional<Rent> searchId(int idRent) {
		// TODO Auto-generated method stub
		return rR.findById(idRent);
	}

	@Override
	public void delete(int idRent) {
		// TODO Auto-generated method stub
		rR.deleteById(idRent);;
		
	}
}
