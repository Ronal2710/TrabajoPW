package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.entity.CategoryProduct;
import pe.edu.upc.repository.ICategoryProductRepository;
import pe.edu.upc.serviceinterface.ICategoryProductService;


@Service
public class CategoryProductService implements ICategoryProductService {
	
	@Autowired
	private ICategoryProductRepository cR;

	@Transactional
	@Override
	public void insert(CategoryProduct categoryProduct) {
		// TODO Auto-generated method stub
		cR.save(categoryProduct);
	}

	@Override
	public List<CategoryProduct> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
