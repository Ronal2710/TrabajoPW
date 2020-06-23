package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	public int insert(CategoryProduct categoryProduct) {
		int rpta=cR.searchCategory(categoryProduct.getNameCategoryProduct());
		if(rpta==0)
		{
			cR.save(categoryProduct);
		}
		return rpta;
	}

	@Override
	public List<CategoryProduct> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}
	
	@Override
	public void delete(int idCategoryProduct) {
		cR.deleteById(idCategoryProduct);
	}
	
	@Override
	public List<CategoryProduct> findNameCategoryProductFull(String nameCategory) {
		// TODO Auto-generated method stub
		return cR.findBynameCategoryProduct(nameCategory);
	}
	
	@Override
	public Optional<CategoryProduct> searchId(int idCategoryProduct) {
		// TODO Auto-generated method stub
		return cR.findById(idCategoryProduct);
	}
	
	



}
