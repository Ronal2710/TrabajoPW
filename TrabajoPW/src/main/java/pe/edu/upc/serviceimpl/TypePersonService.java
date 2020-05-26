package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypePerson;
import pe.edu.upc.repository.ITypePersonRepository;
import pe.edu.upc.serviceinterface.ITypePersonService;


@Service
public class TypePersonService implements ITypePersonService {

	@Autowired
	private ITypePersonRepository cR;

	@Transactional
	@Override
	public void insert(TypePerson typePerson) {
		// TODO Auto-generated method stub
		cR.save(typePerson);
	}

	@Override
	public List<TypePerson> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}
}
