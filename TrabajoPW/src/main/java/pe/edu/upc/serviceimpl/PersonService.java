package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Person;
import pe.edu.upc.repository.IPersonRepository;
import pe.edu.upc.serviceinterface.IPersonService;



@Service
public class PersonService implements IPersonService {
	
	@Autowired
	private IPersonRepository pR;

	@Transactional
	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub
		pR.save(person);
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

}
