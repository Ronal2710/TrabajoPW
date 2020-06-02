package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Bill;
import pe.edu.upc.repository.IBillRepository;
import pe.edu.upc.serviceinterface.IBillService;



@Service
public class BillService implements IBillService {
	
	@Autowired
	private IBillRepository bR;

	@Transactional
	@Override
	public void insert(Bill Bill) {
		// TODO Auto-generated method stub
		bR.save(Bill);
	}

	@Override
	public List<Bill> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}

}
