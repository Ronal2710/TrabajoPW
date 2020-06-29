package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.User;
import pe.edu.upc.repository.IUserRepository;
import pe.edu.upc.serviceinterface.IUserService;


@Service
public class UserService implements IUserService {
	@Autowired
	private IUserRepository uR;

	@Override
	public void insert(User users) {
		uR.save(users);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}
	public void delete(long id) {
		// TODO Auto-generated method stub
		uR.deleteById(id);
	}
}
