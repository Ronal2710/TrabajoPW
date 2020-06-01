package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypeUser;
import pe.edu.upc.repository.ITypeUserRepository;
import pe.edu.upc.serviceinterface.ITypeUserService;







@Service
public class TypeUserService implements ITypeUserService {
	
	@Autowired
	private ITypeUserRepository cR;

	@Transactional
	@Override
	public int insert(TypeUser TypeUser) {
		int rpta=cR.searchTypeUser(TypeUser.getNameTypeUser());
		if(rpta==0)
		{
			cR.save(TypeUser);
		}
		return rpta;
	}

	@Override
	public List<TypeUser> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
