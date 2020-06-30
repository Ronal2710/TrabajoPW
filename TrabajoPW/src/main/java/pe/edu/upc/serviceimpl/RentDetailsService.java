package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.RentDetails;
import pe.edu.upc.repository.IRentDetailRepository;
import pe.edu.upc.serviceinterface.IRentDetailsService;




@Service
public class RentDetailsService implements IRentDetailsService{

	@Autowired
	private IRentDetailRepository ideR;

	@Override
	public void delete(long id) {
		ideR.deleteById(id);
	}

	@Override
	public Integer insert(RentDetails impd) {
		RentDetails impde = ideR.save(impd);
		if (impde == null) {
			return 0;
		} else {
			return 1;
		}
	}

}
