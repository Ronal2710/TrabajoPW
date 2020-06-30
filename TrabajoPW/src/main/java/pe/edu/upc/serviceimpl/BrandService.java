package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.repository.IBrandRepository;
import pe.edu.upc.serviceinterface.IBrandService;

@Service
public class BrandService implements IBrandService{

	@Autowired
	private IBrandRepository bR;

	@Transactional
	@Override
	public int insert(Brand brand) {
		// TODO Auto-generated method stub
		int rpta = bR.searchBrand(brand.getNameBrand());
		if (rpta == 0) {
			bR.save(brand);
		}
		return rpta;
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}

	@Override
	public void delete(int idBrand) {
		// TODO Auto-generated method stub
		bR.deleteById(idBrand);
	}

	@Override
	public List<Brand> findNameBrandFull(String nameBrand) {
		// TODO Auto-generated method stub
		return bR.findBynameBrand(nameBrand);
	}

	@Override
	public Optional<Brand> searchId(int idBrand) {
		// TODO Auto-generated method stub
		return bR.findById(idBrand);
	}
}
