package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Rol;
import pe.edu.upc.repository.IRolRepository;
import pe.edu.upc.serviceinterface.IRolService;



@Service
public class RolService implements IRolService {
	@Autowired
	private IRolRepository rR;

	@Override
	public void insert(Rol role) {
		rR.save(role);
	}

	@Override
	public List<Rol> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

}
