package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Product;
import pe.edu.upc.repository.IProductRepository;

import pe.edu.upc.serviceinterface.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository pR;

	@Transactional
	@Override
	public int insert(Product Product) {
		int rpta=pR.searchProduct(Product.getNameProduct());
		if(rpta==0)
		{
			pR.save(Product);
		}
		return rpta;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

	@Override
	public Optional<Product> searchId(int idProduct) {
		// TODO Auto-generated method stub
		return pR.findById(idProduct);
	}

	@Override
	public List<Product> search(String busqueda) {
		// TODO Auto-generated method stub
		return pR.search(busqueda);
	}

	@Override
	public void delete(int idProduct) {
		// TODO Auto-generated method stub
		pR.deleteById(idProduct);
	}
	
	@Override
	public List<String[]> prodXsale() {
		return pR.prodXsale();
	}
	
	@Override
	public List<String[]> prodXrent() {
		return pR.prodXrent();
	}

}
