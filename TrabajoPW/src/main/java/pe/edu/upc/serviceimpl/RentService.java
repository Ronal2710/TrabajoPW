package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Rent;
import pe.edu.upc.repository.IRentRepository;
import pe.edu.upc.serviceinterface.IRentService;

@Service
public class RentService implements IRentService {
	
	@Autowired
	private IRentRepository pR;
	
	@Override
	@Transactional
	public void insert(Rent rent) {
		// TODO Auto-generated method stub
		pR.save(rent);
	}

	@Override
	public List<Rent> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
