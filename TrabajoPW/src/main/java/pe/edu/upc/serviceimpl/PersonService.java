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
	public int insert(Person person) {
		int rpta=pR.searchPerson(person.getDniPerson());
		if(rpta==0)
		{
			pR.save(person);
		}
		return rpta;
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

}
