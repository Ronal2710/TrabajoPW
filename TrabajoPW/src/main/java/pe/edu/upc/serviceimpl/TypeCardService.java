package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	public int insert(TypeCard typeCard) {
		int rpta=cR.searchTypeCard(typeCard.getNameTypeCard());
		if(rpta==0)
		{
		cR.save(typeCard);
		}
		return rpta;
	}

	@Override
	public List<TypeCard> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int idTypeCard) {
		// TODO Auto-generated method stub
		cR.deleteById(idTypeCard);
	}

	@Override
	public Optional<TypeCard> searchId(int idTypeCard) {
		// TODO Auto-generated method stub
		return cR.findById(idTypeCard);
	}

	@Override
	public List<TypeCard> findNameTypeCardFull(String nameTypeCard) {
		// TODO Auto-generated method stub
		return cR.findBynameTypeCard(nameTypeCard);
	}
}
