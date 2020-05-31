package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Product;
import pe.edu.upc.repository.IProductRepository;

import pe.edu.upc.serviceinterface.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository cR;

	@Transactional
	@Override
	public int insert(Product Product) {
		int rpta=cR.searchProduct(Product.getNameProduct());
		if(rpta==0)
		{
			cR.save(Product);
		}
		return rpta;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
