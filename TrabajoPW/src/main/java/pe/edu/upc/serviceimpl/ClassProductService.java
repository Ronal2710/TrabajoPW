package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.ClassProduct;
import pe.edu.upc.repository.IClassProductRepository;
import pe.edu.upc.serviceinterface.IClassProductService;

@Service
public class ClassProductService implements IClassProductService{
	
	@Autowired
	private IClassProductRepository cR;

	@Transactional
	@Override
	public int insert(ClassProduct classProduct) {
		int rpta=cR.searchClassProduct(classProduct.getNameClassProduct());
		if(rpta==0)
		{
			cR.save(classProduct);
		}
		return rpta;
	}

	@Override
	public List<ClassProduct> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int idClassProduct) {
		// TODO Auto-generated method stub
		cR.deleteById(idClassProduct);
	}

	@Override
	public List<ClassProduct> findNameClassProductFull(String nameClassProduct) {
		// TODO Auto-generated method stub
		return cR.findBynameClassProduct(nameClassProduct);
	}

	@Override
	public Optional<ClassProduct> searchId(int idClassProduct) {
		// TODO Auto-generated method stub
		return cR.findById(idClassProduct);
	}
	
}
