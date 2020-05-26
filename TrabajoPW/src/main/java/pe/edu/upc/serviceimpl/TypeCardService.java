package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypeCard;
import pe.edu.upc.repository.ITypeCardRepository;

import pe.edu.upc.serviceinterface.ITypeCardService;

@Service
public class TypeCardService implements ITypeCardService{
	
	@Autowired
	private ITypeCardRepository cR;

	@Transactional
	@Override
	public void insert(TypeCard typeCard) {
		// TODO Auto-generated method stub
		cR.save(typeCard);
	}

	@Override
	public List<TypeCard> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
